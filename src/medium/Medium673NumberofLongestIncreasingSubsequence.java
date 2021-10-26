package medium;

import java.util.*;

public class Medium673NumberofLongestIncreasingSubsequence {
    class Solution {
        public int findNumberOfLIS(int[] nums) {
            int len = nums.length;
            int[][] dp = new int[len][2]; //  the number of elements longest increasing ending with ith element, 0th for lenLis
            int lenLis = 1;
            for (int i = 0; i < len; i++){
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
    class Solution1 {
        public int findNumberOfLIS(int[] nums) {
            int len = nums.length;
            int[][] dp = new int[len][2]; // 0th for max length, 1th for number of max length
            int maxLength = 0;
            int count = 0;
            for (int i = 0; i < len; i++){
                int curMaxLength = 0;
                int curCount = 0;
                for (int j = 0; j < i; j++){
                    if (nums[i] > nums[j]){
                        if (dp[j][0] + 1 > curMaxLength){
                            curMaxLength = dp[j][0] + 1;
                            curCount = dp[j][1];
                        }
                        else if (dp[j][0] + 1 == curMaxLength){
                            curCount += dp[j][1];
                        }
                    }
                }
                dp[i][0] = curMaxLength == 0 ? 1 : curMaxLength;
                dp[i][1] = curMaxLength == 0 ? 1 : curCount;
                if (dp[i][0] > maxLength){
                    maxLength = dp[i][0];
                    count = dp[i][1];
                }
                else if (dp[i][0] == maxLength){
                    count += dp[i][1];
                }
            }
            return count;
        }
    }
}