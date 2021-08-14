package medium;

public class MinimumPathSum64 {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length;i++){
            for (int j = 0; j < grid[0].length;j++){
                if (i >0 && j > 0){
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]);
                }
                else if (i == 0 && j == 0){

                }
                else if (i ==0){
                    dp[i][j] = dp[i][j-1];
                }
                else if (j == 0){
                    dp[i][j] = dp[i-1][j];
                }

                dp[i][j] +=grid[i][j];
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }

    public int minPathSum1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++){
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++){
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}