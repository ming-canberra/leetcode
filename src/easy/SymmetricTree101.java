package easy;

public class SymmetricTree101 {
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            return helper(root.left, root.right);
        }
        private boolean helper(TreeNode lTree, TreeNode rTree){
            if (lTree == null){
                return rTree == null;
            }
            if (rTree == null){
                return lTree == null;
            }
            if (lTree.val != rTree.val){
                return false;
            }
            boolean result1 = helper(lTree.left, rTree.right);
            boolean result2 = helper(rTree.left, lTree.right);
            return result1 && result2;
        }
    }
}