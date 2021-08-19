package medium;

import java.util.*;

public class LongestIncreasingSubsequence300 {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n]; // ith element, length of LIS ending with element i
            int result = 1;
            for (int i = 0; i < n; i++){
                int max = 1;
                for (int j = 0; j < i; j++){
                    if (nums[i] > nums[j]){
                        max = Math.max(max, dp[j] + 1);
                    }
                }
                dp[i] = max;
                result = Math.max(result, dp[i]);
            }
            return result;
        }
    }
}