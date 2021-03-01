package easy;

public class BestTimeToBuyAndSellStockII122 {
    public static void main(String[] args) {
        BestTimeToBuyAndSellStockII122 thisClass = new BestTimeToBuyAndSellStockII122();
        int ans = thisClass.maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println(ans);
    }
    public int maxProfit(int[] prices) {
        int ans = 0;
        int current = prices[0];
        for (int i = 1; i < prices.length; i++)
        {
            if (prices[i] >= current){
                ans += (prices[i] - current);
                current = prices[i];

            }
            else{
                current = prices[i];
            }
        }

        return ans;
    }
}