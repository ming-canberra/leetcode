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
    class Solution1 {
        public int kConcatenationMaxSum(int[] arr, int k) {
            int mod = (int)Math.pow(10, 9) + 7;
            int result = 0;
            int sum1 = 0;
            int sum = 0;
            for (int i : arr){
                sum += i;
                sum1 += i;
                if (sum1 < 0){
                    sum1 = 0;
                }
                result = Math.max(result, sum1);
            }
            if (k == 1){
                return result;
            }
            else{
                int[] arr2 = new int[arr.length * 2];
                for (int i = 0; i < arr.length; i++){
                    arr2[i] = arr[i];
                    arr2[i + arr.length] = arr[i];
                }

                int sum2 = 0;
                result = 0;
                for (int i : arr2){
                    sum2 += i;
                    if (sum2 < 0){
                        sum2 = 0;
                    }
                    result = Math.max(result, sum2);
                }
                sum2 = result;
                if (sum <= 0){
                    return sum2 % mod;
                }
                else{
                    result = sum2;
                    for (int i = 1; i <= k - 2; i++){
                        result = (sum + result) % mod;
                    }
                    return result % mod;
                }
            }
        }
    }
}