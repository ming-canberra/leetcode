package easy;

import java.util.Arrays;

public class TransposeMatrix867 {
    public static void main(String[] args) {
        TransposeMatrix867 thisClass = new TransposeMatrix867();

        thisClass.transpose(null);
    }
    //do binary search
    public int[][] transpose(int[][] a) {
        int[][]b =new int[a[0].length][a.length];
        for (int i = 0; i < a.length;i++){
            for (int j = 0;j < a[0].length;j++){
                b[j][i] = a[i][j];
            }
        }

        return b;
    }
}