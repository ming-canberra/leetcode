package easy;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        MaximumDepthOfBinaryTree thisClass = new MaximumDepthOfBinaryTree();
        thisClass.maxDepth(null);
        StringBuilder sb = new StringBuilder();
    }
    //bottom-up recursion
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        int lDepth = maxDepth(root.left);
        int rDepth = maxDepth(root.right);
        return Math.max(lDepth + 1, rDepth + 1);
    }
    //top-down recursion
    private int _ans = 0;
    public int maxDepth2(TreeNode root) {
        maximum_depth(root, 1);
        return _ans;
    }

    private void maximum_depth(TreeNode root, int depth){
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            _ans = Math.max(_ans, depth);
        }

        maximum_depth(root.left, depth +1);
        maximum_depth(root.right, depth +1);

    }
}