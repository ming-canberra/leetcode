package medium;

import java.util.Arrays;
//[[67,64,78],[99,98,38],[82,46,46],[6,52,55],[55,99,45]]

public class MatrixBlockSum1314 {
    public static void main(String[] args) {
        MatrixBlockSum1314 thisClass = new MatrixBlockSum1314();
        thisClass.matrixBlockSum(new int[][]{new int[]{67,64,78}, new int[]{99,98,38}, new int[]{82,46,46},
        new int[]{6,52,55}, new int[]{55,99,45}},3);
    }

    public int[][] matrixBlockSum(int[][] mat, int k) {

        int m = mat.length;
        int n = mat[0].length;

        //each sum[i][j] stores the sum of all values BEFORE the current position of the mapped mat position,
        //also add k length padding surrounding the original 'mat'
        int sum[][] = new int [m + k + k + 1][n + k + k + 1];

        for (int i = 0 ; i < sum.length; i++){
            for (int j = 0 ; j < sum[0].length; j++)
            {
                if (i < k + 1){
                    sum[i][j] = 0;
                }
                else if (j < k + 1){
                    sum[i][j] = 0;
                }
                else if( i >= m + k + 1){
                    sum[i][j] = sum[m + k][j];
                }
                else if( j >= n + k + 1){
                    sum[i][j] = sum[i][n + k];
                }
                else{
                    sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + mat[i - k - 1][j - k - 1];
                }
            }
        }

        int toReturn[][] = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                toReturn[i][j] = sum[i + k + k + 1][j + k + k + 1]
                        - sum[i + k + k + 1][j] - sum[i][j + k + k + 1] + sum[i][j];
            }
        }


        return toReturn;
    }
}