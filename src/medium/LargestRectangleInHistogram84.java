package medium;

import java.util.Stack;

public class LargestRectangleInHistogram84 {

    /**
     *  O(N)
     *  O(N)
     * */
    class Solution {
        public int largestRectangleArea(int[] heights) {
            Stack<Integer> stack = new Stack<>();
            int result = 0;
            for (int i = 0; i < heights.length; i++){
                while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                    int topIndex = stack.pop();
                    int topValue = heights[topIndex];
                    // last element
                    if (stack.isEmpty()){
                        result = Math.max(result, topValue * i);
                    }
                    else{
                        result = Math.max(result, topValue * (i - stack.peek() - 1));
                    }
                }
                stack.push(i);
            }
            while(!stack.isEmpty()){
                int topIndex = stack.pop();
                int topValue = heights[topIndex];
                // last element
                if (stack.isEmpty()){
                    result = Math.max(result, topValue * heights.length);
                }
                else{
                    result = Math.max(result, topValue * (heights.length - stack.peek() - 1));
                }
            }
            return result;
        }
    }
}