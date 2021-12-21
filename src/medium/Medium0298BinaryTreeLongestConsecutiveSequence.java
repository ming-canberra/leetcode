package medium;

public class Medium0298BinaryTreeLongestConsecutiveSequence {
    class Solution {
        int result = 1;
        public int longestConsecutive(TreeNode root) {
            getLCSstartingFromMe(root);
            return result;
        }
        private int getLCSstartingFromMe(TreeNode root){
            int curResult = 1;
            if (root.left != null){
                int leftLCS = getLCSstartingFromMe(root.left);
                if (root.val == root.left.val - 1){
                    curResult = Math.max(curResult, 1 + leftLCS);
                }
            }
            if (root.right != null){
                int rightLCS = getLCSstartingFromMe(root.right);
                if (root.val == root.right.val - 1){
                    curResult = Math.max(curResult, 1 + rightLCS);
                }
            }
            result = Math.max(result, curResult);
            return curResult;
        }
    }
}