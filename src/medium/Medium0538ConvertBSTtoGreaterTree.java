package medium;

public class Medium0538ConvertBSTtoGreaterTree {
    class Solution {
        int sum = 0;
        public TreeNode convertBST(TreeNode root) {
            traverse(root);
            return root;
        }
        private void traverse(TreeNode root){
            if (root == null) {
                return;
            }
            traverse(root.right);
            root.val+=sum;
            sum=root.val;
            traverse(root.left);
        }
    }
}