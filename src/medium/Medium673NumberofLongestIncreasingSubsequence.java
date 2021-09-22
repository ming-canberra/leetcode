package medium;

import java.util.*;

public class Medium673NumberofLongestIncreasingSubsequence {
    class Solution {
        public int findNumberOfLIS(int[] nums) {
            int len = nums.length;
            int[][] dp = new int[len][2]; //  the number of elements longest increasing ending with ith element, 0th for lenLis
            dp[0][0] = 1;
            dp[0][1] = 1;
            int lenLis = 1;
            for (int i = 1; i < len; i++){
                for (int j = 0; j < i; j++){
                    if (nums[i] > nums[j]){
                        int localCur = dp[j][0] + 1;
                        int localCounter = dp[j][1];
                        if (localCur > dp[i][0]){
                            dp[i][0] = localCur;
                            dp[i][1] = localCounter;
                        }
                        else if (localCur == dp[i][0]){
                            dp[i][1] += localCounter;
                        }
                    }
                }
                if (dp[i][0] == 0){
                    dp[i][0] = 1;
                    dp[i][1] = 1;
                }
                lenLis = Math.max(lenLis, dp[i][0]);
            }
            int result = 0;
            for (int i = 0; i < len; i++){
                if (lenLis == dp[i][0]){
                    result += dp[i][1];
                }
            }
            return result;
        }
    }
}