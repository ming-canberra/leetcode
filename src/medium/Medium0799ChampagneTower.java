package medium;

public class Medium0799ChampagneTower {
    class Solution {
        public double champagneTower(int poured, int query_row, int query_glass) {
            double[][] dp = new double[100][100];// the amount of water running through the ith row jth glass
            dp[0][0] = (double)poured;
            for (int i = 1; i <= query_row; i++){
                for (int j = 0; j <= i; j++){
                    if (j == 0){
                        dp[i][j] = dp[i - 1][j] - 1.0 > 0 ? (dp[i - 1][j] - 1.0) * 0.5 : 0.0;
                    }
                    else if (j == i){
                        dp[i][j] = dp[i - 1][j - 1] - 1.0 > 0 ? (dp[i - 1][j - 1] - 1.0) * 0.5 : 0.0;
                    }
                    else{
                        dp[i][j] = dp[i - 1][j] - 1.0 > 0 ? (dp[i - 1][j] - 1.0) * 0.5 : 0.0;
                        dp[i][j] += dp[i - 1][j - 1] - 1.0 > 0 ? (dp[i - 1][j - 1] - 1.0) * 0.5 : 0.0;
                    }
                }
            }
            return dp[query_row][query_glass] > 1.0 ? 1.0 : dp[query_row][query_glass];
        }
    }
}