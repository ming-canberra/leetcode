package hard;

import java.util.*;

public class Hard0042TrappingRainWater {
    /**
     * O(n)
     *
     * */
    class Solution {
        public int trap(int[] height) {
            Stack<Integer> stack = new Stack<>();// monotonic decreasing stack to store index
            int result = 0;
            for (int i = 0; i < height.length; i++){
                while(!stack.isEmpty() && height[stack.peek()] < height[i]){
                    int top = stack.pop();
                    if (!stack.isEmpty()){
                        int prevIndex = stack.peek();
                        int minHeight = Math.min(height[prevIndex], height[i]);
                        result += (minHeight - height[top]) * (i - prevIndex - 1);
                    }
                }
                stack.push(i);
            }
            return result;
        }
    }

    class Solution1 {
        public int trap(int[] height) {
            Stack<int[]> stack = new Stack<>();
            int result = 0;
            for (int i = 0; i < height.length; i++){
                if (stack.isEmpty()){
                    stack.push(new int[]{i, height[i]});
                }
                else{
                    while(!stack.isEmpty() && stack.peek()[1] < height[i]){
                        int[] poped = stack.pop();
                        if (!stack.isEmpty()){
                            int[] curTop = stack.peek();
                            result += (Math.min(height[i], curTop[1]) - poped[1]) * (i - curTop[0] - 1);
                        }
                    }
                    stack.push(new int[]{i, height[i]});
                }
            }
            return result;
        }
    }

    class Solution2 {
        public int trap(int[] height) {
            Stack<Integer> stack = new Stack<>();  // monotonic decreasing stack
            int sum = 0;
            for (int i = 0; i < height.length; i++){
                while(!stack.isEmpty() && height[stack.peek()]  < height[i]){
                    int bottomEdgeIdx = stack.pop();

                    if (!stack.isEmpty()){
                        sum += (Math.min(height[stack.peek()], height[i]) - height[bottomEdgeIdx] ) * (i - stack.peek() - 1);
                    }

                }

                stack.push(i);

            }
            return sum;
        }
    }
}