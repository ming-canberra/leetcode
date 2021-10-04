package medium;

import java.util.*;

public class Medium1262GreatestSumDivisiblebyThree {
    class Solution {
        public int maxSumDivThree(int[] nums) {
            int len = nums.length;
            int[][]dp = new int[len + 1][3];
            for (int i = 0; i < len; i++){
                if (nums[i] % 3 == 0){
                    dp[i + 1][0] = dp[i][0] + nums[i];

                    if (dp[i][1] != 0){
                        dp[i + 1][1] = dp[i][1] + nums[i];
                    }

                    if (dp[i][2] != 0){
                        dp[i + 1][2] = dp[i][2] + nums[i];
                    }
                }
                else if (nums[i] % 3 == 1){
                    if (dp[i][2] != 0){
                        dp[i + 1][0] = dp[i][2] + nums[i];
                    }

                    dp[i + 1][1] = dp[i][0] + nums[i];

                    if (dp[i][1] != 0){
                        dp[i + 1][2] = dp[i][1] + nums[i];
                    }
                }
                else{
                    if (dp[i][1] != 0){
                        dp[i + 1][0] = dp[i][1] + nums[i];
                    }

                    if (dp[i][2] != 0){
                        dp[i + 1][1] = dp[i][2] + nums[i];
                    }

                    dp[i + 1][2] = dp[i][0] + nums[i];
                }
                for (int j = 0; j < 3; j++){
                    dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j]);
                }
            }
            return dp[len][0];
        }
    }
}