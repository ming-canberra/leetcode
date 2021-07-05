package medium;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindromicSubsequence516 {
    class Solution {
        public int longestPalindromeSubseq(String s) {
            int n = s.length();
            int[][] dp = new int[n][n];// the longest length for s.substring(i, j + 1);
            for (int i = n - 1; i >= 0; i--){
                for (int j = i; j < n; j++){
                    if (i == j){
                        dp[i][j] = 1;
                    }
                    else{
                        if (s.charAt(i) == s.charAt(j)){
                            dp[i][j] = dp[i + 1][j - 1] + 2;
                        }
                        else{
                            dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                        }
                    }
                }
            }
            return dp[0][n - 1];
        }
    }
}