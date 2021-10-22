package medium;

import java.util.*;

public class Medium1339MaximumProductofSplittedBinaryTree {
    class Solution {
        private int sum = 0;
        private long result = 0;
        public int maxProduct(TreeNode root) {
            sum(root);
            traverse(root);

            return (int)(result % (Math.pow(10, 9) + 7) );
        }
        private int traverse(TreeNode root){
            if (root == null){
                return 0;
            }
            int leftSum = traverse(root.left);
            int rightSum = traverse(root.right);
            if (root.left != null){
                this.result = Math.max(this.result, (long)leftSum * (this.sum - leftSum));
            }
            if (root.right != null){
                this.result = Math.max(this.result, (long)rightSum * (this.sum - rightSum));
            }
            return root.val + leftSum + rightSum;
        }
        private void sum(TreeNode root){
            if (root == null){
                return;
            }
            this.sum += root.val;
            sum(root.left);
            sum(root.right);
        }
    }
}