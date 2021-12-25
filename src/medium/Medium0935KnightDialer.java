package medium;

import java.util.HashMap;
import java.util.Map;

public class Medium0935KnightDialer {
    class Solution {
        public int knightDialer(int n) {
            int mod = 1000000007;

            int[][] dp = new int[n][10];


            for (int i = 0; i < n; i++){
                if (i == 0){
                    for (int j = 0; j < 10; j++){
                        dp[i][j] = 1;
                    }
                }
                else{
                    dp[i][5] = 0;
                    dp[i][1] = (dp[i - 1][6] + dp[i - 1][8] ) % mod;
                    dp[i][2] = (dp[i - 1][7] + dp[i - 1][9] ) % mod;
                    dp[i][3] = (dp[i - 1][4] + dp[i - 1][8] ) % mod;

                    dp[i][4] = ((dp[i - 1][3] + dp[i - 1][9]) % mod + dp[i - 1][0] ) % mod;
                    dp[i][6] = ((dp[i - 1][0] + dp[i - 1][1]) % mod + dp[i - 1][7] ) % mod;

                    dp[i][7] = (dp[i - 1][2] + dp[i - 1][6] ) % mod;
                    dp[i][8] = (dp[i - 1][1] + dp[i - 1][3] ) % mod;
                    dp[i][9] = (dp[i - 1][2] + dp[i - 1][4] ) % mod;
                    dp[i][0] = (dp[i - 1][4] + dp[i - 1][6] ) % mod;

                }


            }
            int result = 0;
            for (int i = 0; i < 10; i++){

                result = (result + dp[n - 1][i]) % mod;
            }

            return result;
        }
    }
}