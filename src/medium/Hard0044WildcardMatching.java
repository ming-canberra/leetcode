package medium;

public class Hard0044WildcardMatching {
    class Solution {
        public boolean isMatch(String s, String p) {
            int lenS = s.length();
            int lenP = p.length();
            boolean dp[][] = new boolean[lenS + 1][lenP + 1];
            dp[0][0] = true;
            for (int i = 1; i < lenP + 1; i++){
                if (p.charAt(i - 1) == '*'){
                    dp[0][i] = dp[0][i - 1];
                }
            }
            for (int i = 1; i < lenS + 1; i++){
                for (int j = 1; j < lenP + 1; j++){
                    if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)){
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                    else if (p.charAt(j - 1) == '*'){
                        dp[i][j] = dp[i-1][j] || dp[i][j-1];
                    }
                }
            }
            return dp[lenS][lenP];
        }
    }

    class Solution1 {
        public boolean isMatch(String s, String p) {
            int m = s.length();
            int n = p.length();
            boolean[][] dp = new boolean[m + 1][n + 1];
            for (int i = 0; i < m + 1; i++){
                for (int j = 0; j < n + 1; j++){
                    if (i == 0 && j == 0){
                        dp[i][j] = true;
                    }
                    else if (j == 0){
                        dp[i][j] = false;
                    }
                    else if (i == 0){
                        dp[i][j] = dp[i][j - 1] && (p.charAt(j - 1) == '*');
                    }
                    else{
                        if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?' ){
                            dp[i][j] = dp[i - 1][j - 1];
                        }
                        else if (p.charAt(j - 1) == '*'){
                            dp[i][j] = dp[i - 1][j - 1] || dp[i - 1][j] || dp[i][j - 1];
                        }
                    }
                }
            }
            return dp[m][n];
        }
    }
}