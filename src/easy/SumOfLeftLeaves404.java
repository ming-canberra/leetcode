package easy;

public class SumOfLeftLeaves404 {
    public static void main(String[] args) {
        SumOfLeftLeaves404 thisClass = new SumOfLeftLeaves404();
        System.out.println(thisClass.sumOfLeftLeaves(null));
    }

    int sum =0;

    public int sumOfLeftLeaves(TreeNode root) {

        traverse(root);

        return sum;
    }

    private void traverse(TreeNode root){
        if (root == null){
            return;
        }

        if (root.left != null){
            if (root.left.left == null && null == root.left.right){
                sum +=root.left.val;
            }
        }

        traverse (root.left);
        traverse (root.right);
    }
}