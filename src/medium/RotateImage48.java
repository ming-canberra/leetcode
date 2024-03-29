package medium;

public class RotateImage48 {
    class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            for (int i = 0; i < n/2; i++){
                for (int j = i; j < n - 1 - i; j++){
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[n - 1 - j][i];
                    matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                    matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                    matrix[j][n - 1 - i] = tmp;
                }
            }
        }
    }

    class Solution1 {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            for (int i = 0; i < n / 2; i++){
                for (int j = i; j < n - i - 1; j++){
                    // top
                    int tmp = matrix[i][j];
                    // left to top
                    matrix[i][j] = matrix[n - 1 - j][i];
                    // bottom to left
                    matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                    // right to bottom
                    matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                    // top to right
                    matrix[j][n - 1 - i] = tmp;
                }
            }
        }
    }
}