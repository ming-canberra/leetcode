package easy;

public class PathSum {
    public static void main(String[] args) {
        PathSum thisClass = new PathSum();
        boolean result = thisClass.hasPathSum(null, 1);
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

    class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null){
                return false;
            }
            return foundPath(root, targetSum, 0);
        }
        private boolean foundPath(TreeNode root, int target, int sum){
            if (root.left == null && root.right == null)
            {
                return sum + root.val == target;
            }

            if (root.left != null){
                boolean l = foundPath(root.left, target, sum + root.val);
                if (l){
                    return true;
                }
            }

            if (root.right != null){
                boolean r = foundPath(root.right, target, sum + root.val);
                if (r){
                    return true;
                }
            }

            return false;
        }
    }
}