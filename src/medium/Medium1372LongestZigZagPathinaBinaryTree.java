package medium;

public class Medium1372LongestZigZagPathinaBinaryTree {
    class Solution {
        int result = 0;
        public int longestZigZag(TreeNode root) {
            getZ(root);
            return result;
        }
        // 0th for left child Z length, 1th for right child Z length
        private int[] getZ(TreeNode root){
            if (root == null){
                return null;
            }
            int lResult = 0;
            int[] lChildZ = getZ(root.left);
            if (lChildZ != null){
                lResult = lChildZ[1] + 1;
                result = Math.max(result, lResult);
            }
            int rResult = 0;
            int[] rChildZ = getZ(root.right);
            if (rChildZ != null){
                rResult = rChildZ[0] + 1;
                result = Math.max(result, rResult);
            }
            return new int[]{lResult, rResult};
        }
    }
}