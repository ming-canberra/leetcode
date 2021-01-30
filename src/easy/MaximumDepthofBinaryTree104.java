package easy;

public class MaximumDepthofBinaryTree104 {
    public static void main(String[] args) {
        MaximumDepthofBinaryTree104 thisClass = new MaximumDepthofBinaryTree104();
        System.out.println(thisClass.maxDepth(null));
    }

    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}