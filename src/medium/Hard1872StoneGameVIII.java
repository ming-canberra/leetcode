package medium;

public class Hard1872StoneGameVIII {
    class Solution {
        public int stoneGameVIII(int[] stones) {
            int[] sum = new int[stones.length];
            int total = 0;
            for (int i = 0; i < stones.length; i++){
                total += stones[i];
                sum[i] = total;
            }
            return getOptimal(stones, new Integer[stones.length], 0, sum);
        }
        private int getOptimal(int[] stones, Integer[] memo, int start, int[] sum) {
            if (memo[start] != null){
                return memo[start];
            }
            if (start == stones.length - 2){
                memo[start] = sum[stones.length - 1];
                return memo[start];
            }
            int b = getOptimal(stones, memo, start + 1, sum);
            int a = sum[start + 1] - b;
            memo[start] = Math.max(a, b);
            return memo[start];
        }
    }
}