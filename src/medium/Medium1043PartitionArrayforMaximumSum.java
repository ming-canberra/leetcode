package medium;

public class Medium1043PartitionArrayforMaximumSum {
    class Solution {
        public int maxSumAfterPartitioning(int[] arr, int k) {
            int len = arr.length;
            int[] dp = new int[len];
            int maxFirstK = 0;
            for(int i = 0; i < len; i++){
                if (i < k){
                    maxFirstK = Math.max(maxFirstK, arr[i]);
                    dp[i] = (1 + i) * maxFirstK;
                }
                else{
                    int maxReverse = 0;
                    int maxSum = 0;
                    for (int j = 1; j <= k; j++){
                        maxReverse = Math.max(maxReverse, arr[i - j + 1]);
                        maxSum = Math.max(maxSum, dp[i - j] + j * maxReverse);
                    }
                    dp[i] = maxSum;
                }
            }
            return dp[len - 1];
        }
    }
}