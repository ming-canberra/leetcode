package medium;

public class DeleteandEarn740 {
    class Solution {
        public int deleteAndEarn(int[] nums) {
            int[] sums = new int[10001];
            for (int i : nums){
                sums[i] += i;
            }
            int[] dp = new int[sums.length];
            dp[1] = sums[1];
            for (int i = 2; i < sums.length; i++){
                dp[i] = Math.max(dp[i - 1], sums[i] + dp[i - 2]);
            }
            return dp[sums.length - 1];
        }
    }
}