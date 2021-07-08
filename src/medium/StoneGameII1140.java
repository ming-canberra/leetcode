package medium;

public class StoneGameII1140 {
    class Solution {
        int[] sum;
        int[][] memo;
        public int stoneGameII(int[] piles) {
            sum = new int[piles.length];
            sum[0] = piles[0];
            for (int i = 1; i < piles.length; i++){
                sum[i] = sum[i - 1] + piles[i];
            }
            memo = new int[piles.length][piles.length * 2];
            return dfs(piles, 0, 1);
        }
        private int getSum(int start, int end){
            if (start == 0){
                return sum[end];
            }
            else{
                return sum[end] - sum[start - 1];
            }
        }
        private int dfs(int[] piles, int start, int m){
            if (memo[start][m] > 0){
                return memo[start][m];
            }
            // last player takes all
            if (start + m * 2 >= piles.length){
                memo[start][m] = getSum(start, piles.length - 1);
                return memo[start][m];
            }
            int max = 0;
            for (int x = 1; x <= m * 2; x++){
                int curTake = getSum(start, start + x - 1);
                int nextTake = getSum(start + x, piles.length - 1) - dfs(piles, start + x, Math.max(m, x));
                max = Math.max(max, curTake + nextTake);
            }
            memo[start][m] = max;
            return memo[start][m];
        }
    }
}