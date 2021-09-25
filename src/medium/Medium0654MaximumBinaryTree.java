package medium;

public class Medium0654MaximumBinaryTree {
    class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return buildTree(nums, 0, nums.length - 1);
        }
        private TreeNode buildTree(int[] nums, int start, int end){
            if (start < 0 || start >= nums.length || end < 0 || end >= nums.length){
                return null;
            }
            if (start > end){
                return null;
            }
            int index = start;
            for (int i = start + 1; i <= end; i++){
                if (nums[i] > nums[index]){
                    index = i;
                }
            }
            TreeNode result = new TreeNode(nums[index]);
            result.left = buildTree(nums, start, index - 1);
            result.right = buildTree(nums, index + 1, end);
            return result;
        }
    }
}