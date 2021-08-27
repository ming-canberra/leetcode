package medium;

import java.util.*;

public class MaximumLengthofRepeatedSubarray718 {
    class Solution {
        public int findLength(int[] nums1, int[] nums2) {
            int n1 = nums1.length;
            int n2 = nums2.length;
            int[][] dp = new int[n1 + 1][n2 + 1];// store the maximum length ending with current i and j
            int result = 0;
            for (int i = 1; i < n1 + 1; i++){
                for (int j = 1; j < n2 + 1; j++){
                    if (nums1[i - 1] == nums2[j - 1]){
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        result = Math.max(result, dp[i][j]);
                    }
                }
            }
            return result;
        }
    }
}