package easy;

public class PathSum {
    public static void main(String[] args) {
        PathSum thisClass = new PathSum();
        boolean result = thisClass.pathSum(null, 1);
        System.out.println(result);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null){
            return false;
        }
        return sum(root, 0, targetSum);
    }

    private boolean sum(TreeNode current, int ancestorSum, int targetSum){
        int ancestorAndMeSum = ancestorSum + current.val;
        if (current.left == null && current.right == null){
            return ancestorAndMeSum == targetSum;
        }
        else if (current.left != null && current.right != null){
            return sum(current.left, ancestorAndMeSum, targetSum) || sum(current.right, ancestorAndMeSum, targetSum);
        }
        else if (current.left == null){
            return sum(current.right, ancestorAndMeSum, targetSum);
        }
        else{
            return sum(current.left, ancestorAndMeSum, targetSum);
        }
    }
}