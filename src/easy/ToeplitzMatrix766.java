package easy;

import java.util.HashMap;

public class ToeplitzMatrix766 {
    public static void main(String[] args) {
        ToeplitzMatrix766 thisClass = new ToeplitzMatrix766();
        System.out.println(thisClass.isToeplitzMatrix(new int[][]{{1,2,3,4},{5,1,2,3},
                {9,5,1,2}}));
    }
    public boolean isToeplitzMatrix(int[][] matrix) {

        HashMap<Integer, Integer> diffToValue = new HashMap<Integer, Integer>();

        for (int i =0;i < matrix.length;i++){
            for(int j = 0; j < matrix[0].length;j++){
                if (!diffToValue.containsKey(j-i)){
                    diffToValue.put(j-i, matrix[i][j]);
                }
                else{
                    if (diffToValue.get(j-i) != matrix[i][j]){
                        return false;
                    }
                }
            }
        }

        return true;
    }
}