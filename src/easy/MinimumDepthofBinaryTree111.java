package easy;

public class MinimumDepthofBinaryTree111 {
    public static void main(String[] args) {
        MinimumDepthofBinaryTree111 thisClass = new MinimumDepthofBinaryTree111();
        System.out.println(thisClass.minDepth(null));
    }

    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        if (root.left != null && root.right == null ){
            return minDepth (root.left) +1 ;
        }
        if (root.right != null && root.left == null ){
            return minDepth (root.right)+ 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}