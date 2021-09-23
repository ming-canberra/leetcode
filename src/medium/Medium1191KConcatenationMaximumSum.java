package medium;

public class Medium1191KConcatenationMaximumSum {
    class Solution {
        public int kConcatenationMaxSum(int[] arr, int k) {
            int len = arr.length;
            int[] arr2 = new int[len * 2];
            int sum = 0;
            for (int i = 0; i < len; i++){
                if (i < len){
                    sum += arr[i];
                }
                arr2[i] = arr[i];
                arr2[i + len] = arr[i];
            }
            long[] dp = new long[len * 2];
            long max1 = arr[0];
            long max2 = arr[0];
            dp[0] = arr[0];
            for (int i = 1; i < dp.length; i++){
                dp[i] = Math.max(arr2[i], (dp[i - 1] + arr2[i]));
                if (i < len){
                    max1 = Math.max(max1, dp[i]);
                }
                max2 = Math.max(max2, dp[i]);
            }
            if (k == 1){
                return max1 < 0 ? 0 : (int)(max1 % 1000000007);
            }
            else{
                long result = max2;
                if (sum > 0){
                    for (int i = k - 2; i > 0; i--){
                        result = (result + sum) % 1000000007;
                    }
                }
                return result < 0 ? 0 : (int)(result % 1000000007);
            }
        }
    }
}