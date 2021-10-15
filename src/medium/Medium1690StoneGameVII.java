package medium;

public class Medium1690StoneGameVII {
    class Solution {
        int[] sum;
        public int stoneGameVII(int[] stones) {
            int len = stones.length;
            sum = new int[len];
            int tmp = 0;
            for (int i = 0; i < len; i++){
                tmp += stones[i];
                sum[i] = tmp;
            }
            return getOptimal(stones, sum, 0, len - 1, new int[len][len]);
        }
        private int getOptimal(int[] stones, int[] sum, int start, int end, int[][]memo){
            if (start >= end ){
                return 0;
            }
            if(memo[start][end] > 0){
                return memo[start][end];
            }
            int a = sum[end] - sum[start] - getOptimal(stones, sum, start + 1, end, memo);
            int b = sum[end - 1] - (start == 0 ? 0 : sum[start - 1]) - getOptimal(stones, sum, start, end - 1, memo);
            memo[start][end] = Math.max(a, b);
            return memo[start][end];
        }
    }
}