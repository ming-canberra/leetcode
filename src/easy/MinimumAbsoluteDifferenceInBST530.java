package easy;

public class MinimumAbsoluteDifferenceInBST530 {
    public static void main(String[] args) {
        MinimumAbsoluteDifferenceInBST530 thisClass = new MinimumAbsoluteDifferenceInBST530();
        int result = thisClass.getMinimumDifference(null);
        System.out.println(result);
    }

    private int _ans = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        fun(root);
        return _ans;
    }

    private void fun(TreeNode root){
        if (root.left != null){
            _ans = Math.min(_ans, root.val - getMostRightChild(root.left));
            fun(root.left);
        }

        if (root.right != null){
            _ans = Math.min(_ans, getMostLeftChild(root.right) - root.val);
            fun(root.right);
        }
    }

    private int getMostRightChild(TreeNode root){
        if (root.right == null){
            return root.val;
        }
        else{
            return getMostRightChild(root.right);
        }
    }

    private int getMostLeftChild(TreeNode root){
        if (root.left == null){
            return root.val;
        }
        else{
            return getMostLeftChild(root.left);
        }
    }
}