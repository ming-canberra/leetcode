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
}