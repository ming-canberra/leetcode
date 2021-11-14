package medium;
import java.util.*;

public class FindLeavesOfBinaryTree366 {
    public static void main(String[] args) {
        FindLeavesOfBinaryTree366 thisClass = new FindLeavesOfBinaryTree366();
    }

    /**
     * space O(N)
     * time O(N)
     * it is still slow, too much code
     * */
    public List<List<Integer>> findLeaves(TreeNode root) {
        Map<TreeNode, TreeNode> childParentMap = new HashMap<>();
        Map<TreeNode, Integer> nodeNumMap = new HashMap<>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<TreeNode> leavesList = new ArrayList<TreeNode>();
        traverse(root, childParentMap, nodeNumMap, leavesList);
        while(leavesList.size() > 0){
            Set<TreeNode> nextLeavesList = new HashSet<TreeNode>();
            List<Integer> tmpList = new ArrayList<Integer>();
            for (TreeNode t : leavesList){
                TreeNode parent = childParentMap.get(t);
                if (parent != null){
                    nodeNumMap.put(parent, nodeNumMap.get(parent) - 1);
                    if (nodeNumMap.get(parent) == 0){
                        nextLeavesList.add(parent);
                        nodeNumMap.remove(parent);
                    }
                }
                tmpList.add(t.val);
            }
            result.add(tmpList);
            leavesList = new ArrayList<TreeNode>(nextLeavesList);
        }
        return result;
    }

    private void traverse(TreeNode node, Map<TreeNode, TreeNode> childParentMap, Map<TreeNode, Integer> nodeNumMap, List<TreeNode> leavesList){
        if (node != null){
            int numChildren = 0;
            if (node.left != null){
                numChildren++;
                childParentMap.put(node.left, node);
            }

            if (node.right != null){
                numChildren++;
                childParentMap.put(node.right, node);
            }
            if (numChildren > 0){
                nodeNumMap.put(node, numChildren);
            }
            else{
                leavesList.add(node);
            }

            traverse(node.left, childParentMap, nodeNumMap, leavesList);
            traverse(node.right, childParentMap, nodeNumMap, leavesList);
        }
    }
    /**
     * topological sort
     *
     * too much coding
     *
     * * */
    class Solution {
        public List<List<Integer>> findLeaves(TreeNode root) {

            Map<TreeNode, TreeNode> childToParent = new HashMap<>();
            Map<TreeNode, Integer> inDegrees = new HashMap<>();

            traverse(root, childToParent, inDegrees);

            Queue<TreeNode> queue = new LinkedList<>();

            List<List<Integer>> result = new ArrayList<>();

            for (TreeNode node : inDegrees.keySet()){
                if (inDegrees.get(node) == 0){
                    queue.add(node);
                }
            }

            while(!queue.isEmpty()){
                List<Integer> curList = new ArrayList<>();

                for(int size = queue.size(); size > 0; size--){
                    TreeNode top = queue.poll();

                    curList.add(top.val);
                    if (childToParent.containsKey(top)){
                        TreeNode theParent = childToParent.get(top);
                        inDegrees.put(theParent, inDegrees.get(theParent) - 1);

                        if (inDegrees.get(theParent) == 0){
                            queue.add(theParent);
                        }
                    }
                }

                result.add(curList);
            }

            return result;
        }

        private void traverse(TreeNode root, Map<TreeNode, TreeNode> childToParent,  Map<TreeNode, Integer> inDegrees){
            if (root != null){
                inDegrees.put(root, 0);
                if (root.left != null){
                    childToParent.put(root.left, root);
                    inDegrees.put(root, inDegrees.get(root) + 1);
                    traverse(root.left, childToParent, inDegrees);
                }

                if (root.right != null){
                    childToParent.put(root.right, root);
                    inDegrees.put(root, inDegrees.get(root) + 1);
                    traverse(root.right, childToParent, inDegrees);
                }
            }
        }
    }
}