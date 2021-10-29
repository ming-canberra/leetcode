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
    /**
     *  N*LOG(N)
    * */
    class Solution1 {
        public int maxSumDivThree(int[] nums) {
            Arrays.sort(nums);
            int sum = 0;
            int minMod1First = 0;
            int minMod1Second = 0;
            int minMod2First = 0;
            int minMod2Second = 0;
            for (int i : nums){
                if (i % 3 == 1 && minMod1First == 0){
                    minMod1First = i;
                }
                else if (i % 3 == 2 && minMod2First == 0){
                    minMod2First = i;
                }
                else if (i % 3 == 1 && minMod1First != 0 && minMod1Second == 0){
                    minMod1Second = i;
                }
                else if (i % 3 == 2 && minMod2First != 0 && minMod2Second == 0){
                    minMod2Second = i;
                }
                sum += i;
            }
            if (sum % 3 == 0){
                return sum;
            }
            else if (sum % 3 == 1){
                int min = Integer.MAX_VALUE;
                if (minMod1First > 0){
                    min = minMod1First;
                }
                if (minMod2First > 0 && minMod2Second > 0){
                    min = Math.min(min, minMod2First + minMod2Second);
                }
                if (min == Integer.MAX_VALUE){
                    return 0;
                }
                else{
                    return sum - min;
                }
            }
            else{
                int min = Integer.MAX_VALUE;
                if (minMod2First > 0){
                    min = minMod2First;
                }
                if (minMod1First > 0 && minMod1Second > 0){
                    min = Math.min(min, minMod1First + minMod1Second);
                }
                if (min == Integer.MAX_VALUE){
                    return 0;
                }
                else{
                    return sum - min;
                }
            }
        }
    }
}