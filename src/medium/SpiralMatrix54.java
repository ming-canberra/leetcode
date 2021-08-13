package medium;

import java.util.*;

public class SpiralMatrix54 {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int top = 0;
            int bottom = matrix.length - 1;
            int left = 0;
            int right = matrix[0].length - 1;
            List<Integer> result = new ArrayList<>();
            while(true){
                //top
                for (int i = left; i <= right; i++){
                    result.add(matrix[top][i]);
                }
                top++;
                if (top > bottom || left > right){
                    break;
                }
                //right
                for (int i = top; i <= bottom; i++){
                    result.add(matrix[i][right]);
                }
                right--;
                if (top > bottom || left > right){
                    break;
                }
                //bottom
                for (int i = right; i >= left; i--){
                    result.add(matrix[bottom][i]);
                }
                bottom--;
                if (top > bottom || left > right){
                    break;
                }
                //left
                for (int i = bottom; i >= top; i--){
                    result.add(matrix[i][left]);
                }
                left++;
                if (top > bottom || left > right){
                    break;
                }
            }
            return result;
        }
    }

    class Solution1 {
        public List<Integer> spiralOrder(int[][] matrix) {
            int top = 0;
            int bottom = matrix.length - 1;
            int left = 0;
            int right = matrix[0].length - 1;
            List<Integer> result = new ArrayList<>();
            while(true){
                //top
                for (int i = left; i <= right; i++){
                    result.add(matrix[top][i]);
                }
                top++;
                if (top > bottom || left > right){
                    break;
                }
                //right
                for (int i = top; i <= bottom; i++){
                    result.add(matrix[i][right]);
                }
                right--;
                if (top > bottom || left > right){
                    break;
                }
                //bottom
                for (int i = right; i >= left; i--){
                    result.add(matrix[bottom][i]);
                }
                bottom--;
                if (top > bottom || left > right){
                    break;
                }
                //left
                for (int i = bottom; i >= top; i--){
                    result.add(matrix[i][left]);
                }
                left++;
                if (top > bottom || left > right){
                    break;
                }
            }
            return result;
        }
    }
}