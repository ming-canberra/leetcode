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
                pathSum(root.left, new ArrayList<Integer>(ancestorValues), targetSum - root.val);
                pathSum(root.right, ancestorValues, targetSum - root.val);
            }
        }
    }

    class solution2
    {
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            if (root == null){
                return result;
            }
            List<Integer> currResult = new ArrayList<Integer>();
            generatePath(root, targetSum, result, currResult, 0);
            return result;
        }
        private void generatePath(TreeNode node, int targetSum, List<List<Integer>> result, List<Integer> currResult, int currSum){
            if (node == null){
                return;
            }
            if (node.left == null && node.right == null){
                if (currSum + node.val == targetSum){
                    currResult.add(node.val);
                    result.add(new ArrayList<Integer>(currResult));
                    currResult.remove(currResult.size() - 1);
                }
                return;
            }
            currResult.add(node.val);
            generatePath(node.left, targetSum, result, currResult, currSum + node.val);
            generatePath(node.right, targetSum, result, currResult, currSum + node.val);
            currResult.remove(currResult.size() - 1);
        }
    }
    class Solution {
        private List<List<Integer>> result = new ArrayList<>();
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            traverse(root, targetSum, new ArrayList<>(), 0);
            return result;
        }
        private void traverse(TreeNode node, int target, List<Integer> list, int sum){
            if (node == null){
                return;
            }
            list.add(node.val);
            sum += node.val;
            if (node.left == null && node.right == null && sum == target){
                result.add(new ArrayList<>(list));
            }
            traverse(node.left, target, list, sum);
            traverse(node.right, target, list, sum);
            list.remove(list.size() - 1);
        }
    }
}