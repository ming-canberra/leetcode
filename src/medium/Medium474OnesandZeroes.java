package medium;

public class Medium474OnesandZeroes {
    class Solution {
        public int findMaxForm(String[] strs, int m, int n) {
            int len = strs.length;
            int[][][]dp = new int[len + 1][m + 1][n + 1];
            for (int i = 1; i < len + 1; i++){
                int oneCount = 0;
                int zeroCount = 0;
                for (int index = 0; index < strs[i - 1].length(); index++){
                    char cc = strs[i - 1].charAt(index);
                    if (cc == '0'){
                        zeroCount++;
                    }
                    else{
                        oneCount++;
                    }
                }
                for (int j = 0; j < m + 1; j++){
                    int jIndex = j - zeroCount;
                    for (int k = 0; k < n + 1; k++){
                        int kIndex = k - oneCount;
                        dp[i][j][k] = dp[i - 1][j][k];
                        if (jIndex >= 0 && kIndex >= 0){
                            dp[i][j][k] = Math.max(dp[i][j][k], 1 + dp[i - 1][j - zeroCount][k - oneCount]);
                        }
                    }
                }
            }
            return dp[len][m][n];
        }
    }

    class Solution1 {
        public int findMaxForm(String[] strs, int m, int n) {
            int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
            for (int i = 1; i < strs.length + 1; i++){
                int one = 0;
                int zero = 0;
                for (char c : strs[i - 1].toCharArray()){
                    if (c == '0'){
                        zero++;
                    }
                    else{
                        one++;
                    }
                }
                for (int j = 0; j < m + 1; j++){
                    for (int k = 0; k < n + 1; k++){

                        // select it
                        int value1 = 0;
                        if (j >= zero && k >= one){
                            value1 = 1 + dp[i - 1][j - zero][k - one];
                        }
                        // not select it
                        dp[i][j][k] = Math.max(value1, dp[i - 1][j][k]);
                    }
                }
            }
            return dp[strs.length][m][n];
        }
    }
}