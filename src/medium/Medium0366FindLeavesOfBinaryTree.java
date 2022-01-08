package medium;
import java.util.*;

public class Medium0366FindLeavesOfBinaryTree {
    public static void main(String[] args) {
        Medium0366FindLeavesOfBinaryTree thisClass = new Medium0366FindLeavesOfBinaryTree();
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

    class Solution2 {

        List<List<Integer>> rlt = new ArrayList<>();

        Map<TreeNode, TreeNode> parents = new HashMap<>();

        public List<List<Integer>> findLeaves(TreeNode root) {
            fillMap(root);

            Queue<TreeNode> queue = new LinkedList<>();

            getLeaves(queue, root);
            HashSet<TreeNode> allLeavesPreviousLayers = new HashSet<>();

            while(!queue.isEmpty()){
                Set<TreeNode> curSet = new HashSet<>();
                for (int size = queue.size(); size > 0; size--){
                    TreeNode top = queue.poll();
                    //if top is a leaf node, add her parent to the queue
                    boolean topIsLeaf = true;
                    if (top.left != null){
                        if (!allLeavesPreviousLayers.contains(top.left)){
                            topIsLeaf = false;
                        }
                    }
                    if (top.right != null){
                        if (!allLeavesPreviousLayers.contains(top.right)){
                            topIsLeaf = false;
                        }
                    }
                    if (topIsLeaf){
                        curSet.add(top);
                        if (parents.containsKey(top)){
                            queue.add(parents.get(top));
                        }
                    }
                }

                allLeavesPreviousLayers.addAll(curSet);
                List<Integer> list = new ArrayList<>();
                for (TreeNode node : curSet){
                    list.add(node.val);
                }
                rlt.add(list);
            }

            return rlt;
        }
        private void getLeaves(Queue<TreeNode> queue, TreeNode root){
            if (root != null){
                getLeaves(queue, root.left);
                getLeaves(queue, root.right);
                if (root.left == null && root.right == null){
                    queue.add(root);
                }
            }
        }

        private void fillMap(TreeNode node){
            if (node.left != null){
                fillMap(node.left);
                parents.put(node.left, node);
            }
            if (node.right != null){
                fillMap(node.right);
                parents.put(node.right, node);
            }
        }
    }
}