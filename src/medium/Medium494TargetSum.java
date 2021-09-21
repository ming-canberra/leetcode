package medium;

import java.util.*;

public class Medium494TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null){
            return 0;
        }

        int[] last = new int[2];
        last[0] = nums[0];
        last[1] = -nums[0];

        for ( int i = 1; i < nums.length; i++)
        {
            int[] current = Arrays.copyOf(last, last.length * 2);
            for (int j = 0; j < last.length; j++){
                current[last.length +j] = last[j] - nums[i];
                current[j] = last[j] + nums[i];
            }
            last = current;
        }

        int toReturn = 0;
        for (int i : last){
            if (i == S){
                toReturn++;
            }
        }

        return toReturn;
    }
    class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            int sum = 0;
            for (int i : nums){
                sum += i;
            }
            if (target > sum || target < -sum){
                return 0;
            }
            int[][] dp = new int[nums.length][sum * 2 + 1];
            for (int i = 0; i < nums.length; i++){
                if (i == 0){
                    dp[i][nums[i] + sum]++;
                    dp[i][-nums[i] + sum]++;
                }
                else{
                    for (int j = 0; j < dp[0].length; j++){
                        if(dp[i - 1][j] > 0){
                            dp[i][nums[i] + j] += dp[i - 1][j];
                            dp[i][-nums[i] + j] += dp[i - 1][j];
                        }
                    }
                }
            }
            return dp[nums.length - 1][target + sum];
        }
    }

    class Solution1 {
        public int findTargetSumWays(int[] nums, int target) {
            int[][] dp = new int[nums.length][2001];// col represents number of expressions that sums to col
            Set<Integer> set = new HashSet<>();
            dp[0][nums[0] + 1000]++;
            dp[0][-nums[0] + 1000]++;
            set.add(nums[0] + 1000);
            set.add(-nums[0] + 1000);
            for (int i = 1; i < dp.length; i++){
                Set<Integer> tmpSet = new HashSet<>();
                for (int j : set){
                    dp[i][j + nums[i]] += dp[i - 1][j];
                    dp[i][j - nums[i]] += dp[i - 1][j];
                    tmpSet.add(j + nums[i]);
                    tmpSet.add(j - nums[i]);
                }
                set = tmpSet;
            }
            return dp[nums.length - 1][target + 1000];
        }
    }
}