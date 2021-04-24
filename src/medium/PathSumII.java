package medium;


import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public static void main(String[] args) {
        PathSumII thisClass = new PathSumII();
        List<List<Integer>> result = thisClass.pathSum(null, 1);
        System.out.println(result);
    }
    private List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        pathSum(root, new ArrayList<Integer>(), targetSum);
        return result;
    }

    private void pathSum(TreeNode root, ArrayList<Integer> ancestorValues, int targetSum) {
        if (root != null){
            ancestorValues.add(root.val);
            if (root.left == null && root.right == null) {
                if (root.val == targetSum) {
                    result.add(ancestorValues);
                }
            }
            else{
                pathSum(root.left, (ArrayList<Integer>)ancestorValues.clone(), targetSum - root.val);
                pathSum(root.right, ancestorValues, targetSum - root.val);
            }
        }
    }
}