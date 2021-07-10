package medium;

public class BestTimetoBuyandSellStockwithTransactionFee714 {
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            int n = prices.length;
            int[] buy = new int[n]; // holding a stock at day i or no transaction, the stock could be either bought today or previous days
            int[] sell = new int[n];// selling a stock at day i or no transaction, the stock must be bought in previous days
            buy[0] = -prices[0];
            for (int i = 1; i < n; i++){
                buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
                sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i] - fee);
            }
            return sell[n - 1];
        }
    }
}