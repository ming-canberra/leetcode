package medium;

public class BestTimetoBuyandSellStockwithCooldown309 {
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int[] dp = new int[n + 2];// max profix if the array starts from i;

            for (int i = n - 2; i >= 0; i--){
                int max = 0;
                for(int sell = i + 1; sell < n; sell++){
                    int curMax = 0;
                    if (prices[sell] > prices[i]){
                        curMax = prices[sell] - prices[i] + dp[sell + 2];
                    }
                    max = Math.max(max, curMax);
                }
                dp[i] = Math.max(max, dp[i + 1]); // sell the stock bought at i or no transaction for i
            }
            return dp[0];
        }
    }}