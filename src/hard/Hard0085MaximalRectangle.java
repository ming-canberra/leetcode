package hard;

import java.util.*;

public class Hard0085MaximalRectangle {
    class Solution {
        public int maximalRectangle(char[][] matrix) {
            int[] heights = new int[matrix[0].length];
            int result = 0;
            for (int i = 0; i < matrix.length; i++){
                for (int j = 0; j < matrix[0].length; j++){
                    if (matrix[i][j] == '1'){
                        heights[j]++;
                    }
                    else{
                        heights[j] = 0;
                    }
                }
                result = Math.max(result, maxHistogram(heights) );
            }
            return result;
        }
        private int maxHistogram(int[] heights){
            int result = 0;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < heights.length; i++){
                while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                    int top = stack.pop();
                    int area;
                    if (stack.isEmpty()){
                        area = heights[top] * i;
                    }
                    else{
                        area = heights[top] * (i - stack.peek() - 1);
                    }
                    result = Math.max(result, area);
                }
                stack.push(i);
            }
            while(!stack.isEmpty()){
                int top = stack.pop();
                int area;
                if (stack.isEmpty()){
                    area = heights[top] * heights.length;
                }
                else{
                    area = heights[top] * (heights.length - stack.peek() - 1);
                }
                result = Math.max(result, area);
            }
            return result;
        }
    }
}