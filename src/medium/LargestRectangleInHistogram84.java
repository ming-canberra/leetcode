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

    class Solution2 {
        public int largestRectangleArea(int[] heights) {
            Stack<int[]> stack = new Stack<>();
            int result = 0;
            for (int i = 0; i < heights.length; i++){
                while(!stack.isEmpty() && stack.peek()[0] > heights[i]){
                    int[] top = stack.pop();
                    int prevBarIndex = stack.isEmpty() ? -1 : stack.peek()[1];
                    result = Math.max(result, (i - prevBarIndex - 1) * top[0]);
                }
                stack.push(new int[]{heights[i], i});
            }
            while(!stack.isEmpty()){
                int[] top = stack.pop();
                int prevBarIndex = stack.isEmpty() ? -1 : stack.peek()[1];
                result = Math.max(result, (heights.length - prevBarIndex - 1) * top[0]);
            }

            return result;
        }
    }
    class Solution1 {
        public int largestRectangleArea(int[] heights) {
            int result = 0;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < heights.length; i++){
                while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                    int top = stack.pop();
                    if (stack.isEmpty()){
                        result = Math.max(result, i * heights[top] );
                    }
                    else{
                        result = Math.max(result, (i - stack.peek() - 1)* heights[top] );
                    }
                }
                stack.push(i);
            }
            if (!stack.isEmpty()){
                int end = stack.peek();
                while(!stack.isEmpty()){
                    int curI = stack.pop();
                    if (stack.isEmpty()){
                        result = Math.max(result, (end + 1) * heights[curI]);
                    }
                    else{
                        result = Math.max(result, (end - stack.peek()) * heights[curI] );
                    }
                }
            }
            return result;
        }
    }
}