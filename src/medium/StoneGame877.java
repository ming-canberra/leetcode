package medium;

public class StoneGame877 {
    class Solution {
        Integer[][] memo;
        public boolean stoneGame(int[] piles) {
            int n = piles.length;
            memo = new Integer[n][n];
            dfs(piles, 0, n - 1);
            return memo[0][n - 1] > 0;
        }
        private int dfs(int[] piles, int start, int end){
            if (memo[start][end] != null ){
                return memo[start][end];
            }
            if (start == end){
                memo[start][end] = piles[end];
                return memo[start][end];
            }
            int cur1 = piles[start] - dfs(piles, start + 1, end);
            int cur2 = piles[end] - dfs(piles, start, end - 1);
            memo[start][end] = Math.max(cur1, cur2);
            return memo[start][end];
        }
    }
}