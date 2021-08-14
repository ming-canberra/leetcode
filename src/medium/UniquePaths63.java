package medium;

public class UniquePaths63 {
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1){
                return 0;
            }
            int[][]dp = new int[m + 1][n + 1];
            for (int i = 1; i < m + 1; i++){
                for (int j = 1; j < n + 1; j++){
                    if (i == 1 && j == 1){
                        dp[i][j] = 1;
                    }
                    else{
                        if(obstacleGrid[i - 1][j - 1] == 1){
                            dp[i][j] = 0;
                        }
                        else{
                            dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                        }
                    }
                }
            }
            return dp[m][n];
        }

        class Solution1 {
            public int uniquePathsWithObstacles(int[][] obstacleGrid) {
                int m = obstacleGrid.length;
                int n = obstacleGrid[0].length;
                int[][] dp = new int[m][n];
                for (int i = 0; i < m; i++){
                    for (int j = 0; j < n; j++){
                        // 1 means obstacle
                        if (obstacleGrid[i][j] == 1){
                            dp[i][j] = 0;
                        }
                        else{
                            if (i == 0 && j == 0){
                                dp[i][j] = 1;
                            }
                            else if (i == 0){
                                dp[i][j] = dp[i][j - 1];
                            }
                            else if (j == 0){
                                dp[i][j] = dp[i - 1][j];
                            }
                            else{
                                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                            }
                        }
                    }
                }
                return dp[m - 1][n - 1];
            }
        }
    }
}