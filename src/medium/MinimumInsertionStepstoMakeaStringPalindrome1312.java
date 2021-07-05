package medium;

import java.util.*;

public class MinimumInsertionStepstoMakeaStringPalindrome1312 {
    class Solution {
        public int minInsertions(String s) {
            int n = s.length();
            int[][] dp = new int[n][n];
            for(int i = n - 1; i >= 0; i--){
                for (int j = i; j < n; j++){
                    if(s.charAt(i) == s.charAt(j)){
                        if (i != j){
                            dp[i][j] = dp[i + 1][j - 1];
                        }
                    }
                    else{
                        dp[i][j] = Math.min(dp[i + 1][j] + 1, 1 + dp[i][j - 1]);
                    }
                }
            }
            return dp[0][n - 1];
        }
    }
}