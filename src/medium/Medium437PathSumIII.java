package medium;
import java.util.*;

public class Medium437PathSumIII {
    public static void main(String[] args) {
        Medium437PathSumIII thisClass = new Medium437PathSumIII();
    }




    /**
     * space O(N)
     * time O(N)
     * */
    private int result = 0;
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        fun(root, targetSum, 0, map);
        return result;
    }
    private void fun(TreeNode curr, int target, int sum, HashMap<Integer, Integer>map)
    {
        if (curr == null){
            return;
        }
        sum += curr.val;
        //check all paths ending with current node, except the one from current to root. See below for the edge case.
        result += map.getOrDefault(sum - target, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        if (curr.left != null){
            fun(curr.left, target, sum, map);
        }
        if (curr.right != null){
            fun(curr.right, target, sum, map);
        }
        //check the path from current to root
        if (sum == target){
            result++;
        }
        // we would like to reuse thie map,
        map.put(sum, map.get(sum) - 1);
    }

    class Solution {
        int result = 0;
        public int pathSum(TreeNode root, int targetSum) {
            traverse(root, targetSum, 0, new HashMap<>());
            return result;
        }
        private void traverse(TreeNode node, int targetSum, int sum, Map<Integer, Integer> map){
            if (node == null){
                return;
            }
            sum += node.val;
            // the path from root to me
            if (sum == targetSum){
                result++;
            }
            if (map.containsKey(sum - targetSum)){
                result += map.get(sum - targetSum);
            }
            // add sum to the map
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            traverse(node.left, targetSum, sum, map);
            traverse(node.right, targetSum, sum, map);
            map.put(sum, map.get(sum) - 1);
        }
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution1 {
        public int pathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return 0;
            }
            int countIncludingRoot = 0;
            if (root.val == targetSum) {
                countIncludingRoot++;
            }
            int leftCount = sumIncludingRoot(root.left, targetSum - root.val);
            int rightCount = sumIncludingRoot(root.right, targetSum - root.val);
            countIncludingRoot = countIncludingRoot + leftCount + rightCount;
            return countIncludingRoot + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
        }

        private int sumIncludingRoot(TreeNode root, int targetSum) {
            if (root == null) {
                return 0;
            }
            int count = 0;

            if (root.val == targetSum) {
                count++;
            }
            int leftCount = sumIncludingRoot(root.left, targetSum - root.val);
            int rightCount = sumIncludingRoot(root.right, targetSum - root.val);
            return count + leftCount + rightCount;
        }
    }
}