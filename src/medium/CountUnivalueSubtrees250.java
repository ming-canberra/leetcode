package medium;

import java.util.Arrays;

public class CountUnivalueSubtrees250 {
    class Solution {
        private int result = 0;
        public int countUnivalSubtrees(TreeNode root) {
            if (root == null){
                return 0;
            }
            isUniValue(root);
            return result;
        }
        private boolean isUniValue(TreeNode root){
            if (root.left == null && root.right == null){
                result++;
                return true;
            }
            boolean leftIsUni = true;
            if (root.left != null){
                leftIsUni = isUniValue(root.left) && root.val == root.left.val;
            }
            boolean rightIsUni = true;
            if (root.right != null){
                rightIsUni = isUniValue(root.right) && root.val == root.right.val;
            }

            boolean isUni = leftIsUni && rightIsUni;
            if (isUni){
                result++;
            }
            return isUni;
        }
    }
}