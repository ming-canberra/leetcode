package medium;

public class MaximumDifferenceBetweenNodeAndAncestor1026 {
    public static void main(String[] args) {
        MaximumDifferenceBetweenNodeAndAncestor1026 thisClass = new MaximumDifferenceBetweenNodeAndAncestor1026();
    }
    //top down DFS
    private int result = 0;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root.left, root.val, root.val);
        dfs(root.right, root.val, root.val);
        return result;
    }
    private void dfs(TreeNode node, int min, int max){
        if (node != null){
            result = Math.max(result, Math.abs(node.val - min));
            result = Math.max(result, Math.abs(node.val - max));
            int tmpMin = Math.min(min, node.val);
            int tmpMax = Math.max(max, node.val);
            dfs(node.left, tmpMin, tmpMax);
            dfs(node.right, tmpMin, tmpMax);
        }
    }
}