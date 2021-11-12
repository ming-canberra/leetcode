package hard;

public class Hard1220CountVowelsPermutation {

    class Solution {
        public int countVowelPermutation(int n) {
            if (n == 1){
                return 5;
            }
            int mod = 1000000007;
            // 0 a
            // 1 e
            // 2 i
            // 3 o
            // 4 u
            int[][] dp = new int[n + 1][5];
            dp[1] = new int[]{1,1,1,1,1};
            dp[2] = new int[]{1,2,4,2,1};
            for (int i = 3; i < n + 1; i++){
                dp[i][0] = dp[i - 1][1];
                dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
                dp[i][2] = ( ((dp[i - 1][0] + dp[i - 1][1]) % mod  + dp[i - 1][3]) % mod + dp[i - 1][4]) % mod;
                dp[i][3] = (dp[i - 1][2] + dp[i - 1][4]) % mod;
                dp[i][4] = dp[i - 1][0];
            }

            int result = 0;
            for (int i = 0; i < 5; i++){
                result = (result + dp[n][i]) % mod;
            }

            return result;
        }
    }


}