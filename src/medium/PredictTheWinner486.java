package medium;

import java.util.Arrays;

public class PredictTheWinner486 {

    /**
     * recursion
     * */
    class Solution {
        public boolean PredictTheWinner(int[] nums) {
            return maxRelativeScore(nums, 0, nums.length - 1) >= 0;
        }
        private int maxRelativeScore(int[] nums, int start, int end){
            if (start == end){
                return nums[start];
            }
            int cur1 = nums[start] - maxRelativeScore(nums, start + 1, end);
            int cur2 = nums[end] - maxRelativeScore(nums, start, end - 1);
            return Math.max(cur1, cur2);
        }
    }

    /**
     * recursion + memoization
     * */
    class Solution1 {
        Integer[][] memo;
        public boolean PredictTheWinner(int[] nums) {
            int n = nums.length;
            memo = new Integer[n][n];
            maxRelativeScore(nums, 0, n - 1);
            return  memo[0][n - 1] >= 0;
        }
        private int maxRelativeScore(int[] nums, int start, int end){
            if (memo[start][end] != null){
                return memo[start][end];
            }
            if (start == end){
                memo[start][end] = nums[start];
                return memo[start][end];
            }
            int cur1 = nums[start] - maxRelativeScore(nums, start + 1, end);
            int cur2 = nums[end] - maxRelativeScore(nums, start, end - 1);
            memo[start][end] = Math.max(cur1, cur2);
            return memo[start][end];
        }
    }

    /**
     * dp
     * */
    class Solution2 {
        public boolean PredictTheWinner(int[] nums) {
            int n = nums.length;
            int[][] dp = new int[n][n];
            for (int i = n - 1; i >= 0; i--){
                for (int j = i; j < n; j++){
                    if (i == j){
                        dp[i][j] = nums[i];
                    }
                    else{
                        dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
                    }
                }
            }
            return  dp[0][n - 1] >= 0;
        }
    }
}