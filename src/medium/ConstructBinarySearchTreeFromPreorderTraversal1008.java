package medium;

import java.util.HashSet;

public class ConstructBinarySearchTreeFromPreorderTraversal1008 {
    public static void main(String[] args) {
        ConstructBinarySearchTreeFromPreorderTraversal1008 thisClass = new ConstructBinarySearchTreeFromPreorderTraversal1008();
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++){
            bst(root, preorder[i]);
        }
        return root;
    }
    private void bst(TreeNode root, int value){
        if (value < root.val){
            if (root.left == null){
                TreeNode newNode = new TreeNode(value);
                root.left = newNode;
                return;
            }
            else{
                bst (root.left, value);
            }
        }
        if (value > root.val){
            if (root.right == null){
                TreeNode newNode = new TreeNode(value);
                root.right = newNode;
                return;
            }
            else{
                bst (root.right, value);
            }
        }
    }


    class Solution {
        public TreeNode bstFromPreorder(int[] preorder) {
            return helper(preorder, 0, preorder.length - 1);
        }
        private TreeNode helper(int[] preorder, int start, int end){
            TreeNode root = new TreeNode(preorder[start]);
            Integer leftStart = null;
            Integer leftEnd = null;
            Integer rightStart = null;
            Integer rightEnd = null;
            for (int i = start + 1; i <= end; i++){
                if (preorder[i] < root.val && leftStart == null){
                    leftStart = i;
                }
                if (preorder[i] < root.val){
                    leftEnd = i;
                }
                if (preorder[i] > root.val  && rightStart == null){
                    rightStart = i;
                }
                if (preorder[i] > root.val){
                    rightEnd = i;
                }
            }
            if (leftStart != null && leftEnd != null){
                root.left = helper(preorder, leftStart, leftEnd);
            }
            if (rightStart != null && rightEnd != null){
                root.right = helper(preorder, rightStart, rightEnd);
            }
            return root;
        }
    }
}