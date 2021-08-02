package easy;

public class ConvertSortedArrayToBinarySearchTree108 {
    public static void main(String[] args) {
        ConvertSortedArrayToBinarySearchTree108 thisClass = new ConvertSortedArrayToBinarySearchTree108();
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length);
    }

    private TreeNode buildTree(int[] nums, int start, int end){
        if (end > start){
            int middle = start + (end - start) / 2;
            TreeNode node = new TreeNode(nums[middle]);
            node.left = buildTree(nums, start, middle);
            node.right = buildTree(nums, middle + 1, end);
            return node;
        }
        return null;
    }

    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return helper(nums, 0, nums.length - 1);
        }
        private TreeNode helper(int[] nums, int start, int end){
            if (start <= end){
                int m = start + (end - start) / 2;
                TreeNode root = new TreeNode(nums[m]);
                root.left = helper(nums, start, m - 1);
                root.right = helper(nums, m + 1, end);
                return root;
            }
            return null;
        }
    }
}