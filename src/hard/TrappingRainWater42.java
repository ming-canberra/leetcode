package hard;

import java.util.*;

public class TrappingRainWater42 {
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
}