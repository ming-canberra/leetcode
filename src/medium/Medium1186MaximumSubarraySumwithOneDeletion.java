package medium;

import java.util.*;

public class Medium1186MaximumSubarraySumwithOneDeletion {
    class Solution {
        public int maximumSum(int[] arr) {
            int len = arr.length;
            int[] dp = new int[len];
            int[] dpDe = new int[len];
            dp[0] = arr[0];
            dpDe[0] = 0;
            int result = arr[0];
            for (int i = 1; i < len; i++){
                dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
                dpDe[i] = Math.max(dp[i - 1], dpDe[i - 1] + arr[i]);
                result = Math.max(result, dp[i]);
                result = Math.max(result, dpDe[i]);
            }
            return result;
        }
    }
}