package medium;

import java.util.*;

public class SpiralMatrixII59 {
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] result = new int[n][n];
            int cur = 0;
            int top = 0;
            int bot = n - 1;
            int left = 0;
            int right = n - 1;
            while(true){
                //top
                for (int i = left; i <= right; i++){
                    cur++;
                    result[top][i] = cur;
                }
                top++;
                if (top > bot || left > right){
                    break;
                }

                //right
                for (int i = top; i <= bot; i++){
                    cur++;
                    result[i][right] = cur;
                }
                right--;
                if (top > bot || left > right){
                    break;
                }

                //bottom
                for (int i = right; i >= left; i--){
                    cur++;
                    result[bot][i] = cur;
                }
                bot--;
                if (top > bot || left > right){
                    break;
                }

                //left
                for (int i = bot; i >= top; i--){
                    cur++;
                    result[i][left] = cur;
                }
                left++;
                if (top > bot || left > right){
                    break;
                }
            }
            return result;
        }
    }
}