package medium;

import java.util.ArrayList;
import java.util.List;

public class CountSquareSubmatriceswithAllOnes1277 {
    public static void main(String[] args) {
        CountSquareSubmatriceswithAllOnes1277 thisClass = new CountSquareSubmatriceswithAllOnes1277();
        Integer f = thisClass.countSquares(new int[][]{new int[]{0,1,1,1}, new int[]{1,1,1,1}, new int[]{0,1,1,1}, });
        System.out.println(f);
    }

    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int toReturn = 0;

        for (int i =0; i < matrix.length;i++){
            for (int j = 0; j < matrix[0].length;j++){
                if (matrix[i][j] == 1){
                    toReturn++;
                }
            }
        }
        int[][] last = matrix;

        for (int length = 1; m - length> 0 && n-length> 0; length++)
        {
            int temp[][] = new int[m - length][n - length];
            for (int i =0; i < temp.length;i++){
                for (int j = 0; j < temp[0].length;j++){
                    if (last[i][j] == 1 && matrix[i + length][j + length] == 1){
                        if (last[i + 1][j]==1 && last[i][j +1] == 1){
                            toReturn++;
                            temp[i][j] = 1;
                        }
                    }
                }
            }
            last = temp;
        }

        return toReturn;
    }
}