package medium;

import java.util.*;

public class Medium0097InterleavingString {
    class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            int n1 = s1.length();
            int n2 = s2.length();
            if (n1 + n2 != s3.length()){
                return false;
            }
            boolean[][] dp = new boolean[n1 + 1][n2 + 1];
            for (int i = 0; i < n1 + 1; i++){
                for (int j = 0; j < n2 + 1; j++){
                    if (i == 0 && j == 0){
                        dp[i][j] = true;
                    }
                    else if (i == 0){
                        if (s2.charAt(j - 1) == s3.charAt(j - 1)){
                            dp[i][j] = dp[i][j - 1];
                        }
                    }
                    else if (j == 0){
                        if (s1.charAt(i - 1) == s3.charAt(i - 1)){
                            dp[i][j] = dp[i - 1][j];
                        }
                    }
                    else{
                        if (s1.charAt(i - 1) == s3.charAt(i + j - 1)){
                            dp[i][j] = dp[i - 1][j] || dp[i][j];
                        }
                        if (s2.charAt(j - 1) == s3.charAt(i + j - 1)){
                            dp[i][j] = dp[i][j - 1] || dp[i][j];
                        }
                    }
                }
            }
            return dp[n1][n2];
        }
    }
}