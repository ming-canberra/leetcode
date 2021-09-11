package medium;

import java.util.Arrays;

public class Medium230KthSmallestElementInABST {
    class Solution {
        Integer result = null;
        int counter = 0;
        public int kthSmallest(TreeNode root, int k) {
            traverse(root, k);
            return result;
        }
        private void traverse(TreeNode root, int k){
            if (root == null){
                return;
            }
            traverse(root.left, k);
            counter++;
            if (counter == k){
                result = root.val;
                return;
            }
            traverse(root.right, k);
        }
    }
}