package medium;

public class SumOfNodesWithEvenValuedGrandparent1315 {
    public static void main(String[] args) {
        SumOfNodesWithEvenValuedGrandparent1315 thisClass = new SumOfNodesWithEvenValuedGrandparent1315();
    }
    //DFS BOTTOM-UP
    private int result = 0;
    public int sumEvenGrandparent(TreeNode root) {
        dfs(root);
        return result;
    }
    // return the sum of my children
    private int dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        int lSum = dfs(root.left);
        int rSum = dfs(root.right);
        if (root.val % 2 == 0){
            result += lSum + rSum;
        }
        int lChild = root.left == null ? 0 : root.left.val;
        int rChild = root.right == null ? 0 : root.right.val;
        return lChild + rChild;
    }
}