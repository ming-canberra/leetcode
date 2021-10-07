package medium;

public class Medium0518CoinChange2 {
    class Solution {
        public int change(int amount, int[] coins) {
            int[][] dp = new int[coins.length + 1][amount + 1];
            for (int i = 1; i < dp.length; i++){
                dp[i][0] = 1;
                for (int j = 1; j < dp[0].length; j++){
                    dp[i][j] = dp[i - 1][j];
                    if (j >= coins[i - 1]){
                        dp[i][j] += dp[i][j - coins[i - 1]];
                    }
                }
            }
            return dp[coins.length][amount];
        }
    }
}