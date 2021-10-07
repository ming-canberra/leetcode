package medium;

public class Medium0377CombinationSumIV {
    class Solution {
        public int combinationSum4(int[] nums, int target) {
            int[] dp = new int[target + 1];
            dp[0] = 1;
            for (int i = 1; i <= target; i++){
                int sum = 0;
                for (int j = 0; j < nums.length; j++){
                    if (i >= nums[j]){
                        sum += dp[i - nums[j]];
                    }
                }
                dp[i] = sum;
            }
            return dp[target];
        }
    }
}