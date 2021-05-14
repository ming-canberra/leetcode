package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DeleteNodesAndReturnForest1110 {
    public static void main(String[] args) {
        DeleteNodesAndReturnForest1110 thisClass = new DeleteNodesAndReturnForest1110();
    }
    private List<TreeNode> result = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null){
            return result;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i : to_delete){
            set.add(i);
        }

        if (!set.contains(root.val)){
            result.add(root);
        }
        dfs(root, set);

        return result;
    }

    private void dfs(TreeNode root, HashSet<Integer> set){
        if (root != null){
            boolean iAmToDelete = set.contains(root.val);

            if (root.left != null){
                TreeNode leftChild = root.left;
                // separate my child from me
                if (set.contains(leftChild.val)){
                    root.left = null;
                }
                else{
                    // add my child to result
                    if (iAmToDelete){
                        result.add(leftChild);
                    }
                }
                dfs(leftChild, set);
            }

            if (root.right != null){
                TreeNode rightChild = root.right;
                if (set.contains(rightChild.val)){
                    root.right = null;
                }
                else{
                    if (iAmToDelete){
                        result.add(rightChild);
                    }
                }
                dfs(rightChild, set);
            }
        }
    }
}