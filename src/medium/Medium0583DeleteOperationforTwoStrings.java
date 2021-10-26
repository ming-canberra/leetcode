package medium;

public class Medium0583DeleteOperationforTwoStrings {
    class Solution {
        public int minDistance(String word1, String word2) {
            // length of longest common subsequence
            int m = word1.length();
            int n = word2.length();
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++){
                for (int j = 1; j <= n; j++){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)){
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                    }
                }
            }
            return m + n - dp[m][n] * 2;
        }
    }
}