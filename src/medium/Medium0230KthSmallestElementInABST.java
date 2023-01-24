package medium;

public class Medium0230KthSmallestElementInABST {
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

    class Solution1 {
        int counter = 0;
        Integer res = null;
        public int kthSmallest(TreeNode root, int k) {
            inOrder(root, k);
            return res;
        }
        private void inOrder(TreeNode root, int k) {
            if (res == null) {
                if (root != null) {
                    inOrder(root.left, k);
                    if (counter != k) {
                        counter++;
                    }
                    if (counter == k && res == null) {
                        res = root.val;
                        return;
                    }
                    inOrder(root.right, k);
                }
            }
        }
    }
}