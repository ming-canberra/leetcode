package medium;

public class SumRootToLeafNumbers129 {
    public static void main(String[] args) {
        SumRootToLeafNumbers129 thisClass = new SumRootToLeafNumbers129();
    }

    private int result = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int sum){
        int currSum = sum * 10 + root.val;
        if (root.left == null && root.right == null){
            result += currSum;
        }
        if (root.left != null){
            dfs(root.left, currSum);
        }
        if (root.right != null){
            dfs(root.right, currSum);
        }
    }
}