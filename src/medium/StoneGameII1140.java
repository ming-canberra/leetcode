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
    class Solution1 {
        public int stoneGameII(int[] piles) {
            int len = piles.length;
            int[][] memo = new int[len][len]; // start, m
            int[] sum = new int[len + 1];
            sum[0] = 0;
            for (int i = 1; i < len + 1; i++){
                sum[i] = sum[i - 1] + piles[i - 1];
            }
            int aliceDiff = getOptimal(piles, 1, 0, sum, memo);
            return (aliceDiff + sum[len]) / 2;
        }
        // sum(i, j) = sum[j + 1] - sum[i]
        private int getOptimal(int[] piles, int m, int start, int[] sum, int[][] memo){
            if (m * 2 >= piles.length - start){
                return sum[piles.length] - sum[start];
            }
            if (memo[start][m] != 0){
                return memo[start][m];
            }
            int max = Integer.MIN_VALUE;
            for (int i = start; i < start + m * 2; i++){
                int tmpMax = sum[i + 1] - sum[start] - getOptimal(piles, Math.max(m, i - start + 1), i + 1, sum, memo);
                if (tmpMax > max){
                    max = tmpMax;
                }
            }
            memo[start][m] = max;
            return memo[start][m];
        }
    }

    class Solution2 {
        Integer[][] memo;
        int[] sums;
        public int stoneGameII(int[] piles) {

            memo = new Integer[100][100];

            sums = new int[piles.length];
            int total = 0;
            for (int i = 0; i < piles.length; i++){
                total += piles[i];
                sums[i] = total;
            }

            int diff = getMax(piles, 0, 1);

            return (total + diff) / 2;
        }

        private int getMax(int[] piles, int start, int m){
            if (m * 2 + start >= piles.length){
                return sum(piles.length - 1) - sum(start - 1);
            }

            if (memo[start][m] != null){
                return memo[start][m];
            }

            int max = Integer.MIN_VALUE;
            for (int i = start; i < start + m * 2; i++){

                max = Math.max(max,  sum(i) - sum(start - 1) - getMax(piles, i + 1,  Math.max(m, i + 1 - start)) );

            }

            memo[start][m] = max;

            return memo[start][m];
        }

        private int sum(int index){
            if (index == -1){
                return 0;
            }

            return sums[index];
        }
    }
}