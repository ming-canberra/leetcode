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
}