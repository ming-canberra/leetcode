package medium;

import java.util.HashSet;

public class MaximalSquare221 {
    public static void main(String[] args) {
        MaximalSquare221 thisClass = new MaximalSquare221();

        int res = thisClass.maximalSquare(new char[][]{new char[]{'1'}});
        System.out.println(res);
    }
    public int maximalSquare(char[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        int result = 0;
        for (int i = 0; i < m; i++){
            dp[i][0] = matrix[i][0] == '1' ? 1:0;
            if (dp[i][0] == 1)
            {
                result = 1;
            }
        }

        for (int j = 0; j < n; j++){
            dp[0][j] = matrix[0][j] == '1' ? 1:0;
            if (dp[0][j] == 1)
            {
                result = 1;
            }
        }

        for (int i = 1; i < m; i++)
        {
            for (int j = 1; j < n; j++)
            {
                if (matrix[i][j] == '1')
                {
                    dp[i][j] = Math.min(Math.min(dp[i -1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }

        return result * result;
    }
}