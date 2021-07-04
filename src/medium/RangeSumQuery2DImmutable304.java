package medium;

import java.util.Arrays;

public class RangeSumQuery2DImmutable304 {
    public static void main(String[] args) {
        RangeSumQuery2DImmutable304 thisClass = new RangeSumQuery2DImmutable304(null);
    }


    private int[][] dp;

    public RangeSumQuery2DImmutable304(int[][] matrix) {
        dp = new int[matrix.length + 1][matrix[0].length + 1];

        for (int i = 1; i < dp.length;i++){
            for (int j = 1 ; j < dp[0].length;j++){
                dp[i][j] =dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {




        return dp[row2 + 1][col2 + 1] + dp[row1 ][col1 ] - dp[row1 ][col2 +1 ] - dp[row2 + 1][col1];
    }

    class NumMatrix {
        int[][] dp;
        int m;
        int n;
        public NumMatrix(int[][] matrix) {
            m = matrix.length;
            n = matrix[0].length;
            dp = new int[m + 1][n + 1];
            for (int i = 0; i < m + 1; i++){
                for (int j = 0; j < n + 1; j++){
                    if (i != 0 && j != 0){
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
                    }
                }
            }
        }
        public int sumRegion(int row1, int col1, int row2, int col2) {
            return dp[1 + row2][1 + col2] + dp[row1][col1] - dp[1 + row2][col1] - dp[row1][1 + col2];
        }
    }
}