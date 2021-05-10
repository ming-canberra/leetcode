package medium;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class PathSumIII {
    public static void main(String[] args) {
        PathSumIII thisClass = new PathSumIII();
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
}