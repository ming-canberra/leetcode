package medium;

import java.util.Arrays;

public class PredictTheWinner486 {

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
}