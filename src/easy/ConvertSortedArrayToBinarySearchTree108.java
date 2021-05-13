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
}