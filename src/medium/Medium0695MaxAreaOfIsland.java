package medium;

public class Medium0695MaxAreaOfIsland {
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

    class Solution1 {
        public double champagneTower(int poured, int query_row, int query_glass) {
            if (query_row == 0){
                return poured >= 1 ? 1.0 : 0.0;
            }

            double[][] dp = new double[query_row][query_row]; // the amount going pass dp[i][j]

            if (poured > 1){
                dp[0][0] = (double)poured - 1.0;

                for (int i = 1; i < query_row; i++){
                    for (int j = 0; j <= i; j++){
                        if (j == 0){
                            double inFirst = dp[i - 1][j] / 2.0;
                            dp[i][j] = inFirst > 1.0 ? inFirst - 1.0 : dp[i][j];
                        }
                        else if (j == i){
                            double inSecond = dp[i - 1][j - 1] / 2.0;
                            dp[i][j] = inSecond > 1.0 ? inSecond - 1.0 : dp[i][j];
                        }
                        else{
                            double inFirst = dp[i - 1][j] / 2.0;
                            double inSecond = dp[i - 1][j - 1] / 2.0;
                            dp[i][j] = inFirst + inSecond > 1.0 ? inFirst + inSecond - 1.0 : dp[i][j];
                        }
                    }
                }
            }

            if (query_glass == 0){
                double inFirst = dp[query_row - 1][query_glass] / 2.0;
                return inFirst > 1.0 ? 1.0 : inFirst;
            }
            else if (query_glass == query_row){
                double inSecond = dp[query_row - 1][query_glass - 1] / 2.0;
                return inSecond > 1.0 ? 1.0 : inSecond;
            }
            else{
                double inFirst = dp[query_row - 1][query_glass] / 2.0;
                double inSecond = dp[query_row - 1][query_glass - 1] / 2.0;

                return inFirst + inSecond > 1.0 ? 1.0 : inFirst + inSecond;
            }
        }
    }
}