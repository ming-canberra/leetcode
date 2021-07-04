package medium;

public class MinimumFallingPathSum931 {
    class Solution {

        public int minFallingPathSum(int[][] matrix) {
            int n = matrix.length;
            int[][] dp = new int[n][n];
            int result = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    if (i == 0){
                        dp[i][j] = matrix[i][j];
                    }
                    else{
                        int left = j - 1 >= 0 ? dp[i - 1][j - 1] + matrix[i][j]: Integer.MAX_VALUE;
                        int middle = dp[i - 1][j] + matrix[i][j];
                        int right = j + 1 < n ? dp[i - 1][j + 1] + matrix[i][j]: Integer.MAX_VALUE;
                        dp[i][j] = Math.min( Math.min(left, middle), right );
                    }
                    if (i == n - 1){
                        result = Math.min(result, dp[i][j]);
                    }
                }
            }
            return result;
        }
    }
}