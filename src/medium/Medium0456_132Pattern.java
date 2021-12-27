package medium;

import java.util.*;

public class Medium0456_132Pattern {
    class Solution {
        public boolean find132pattern(int[] nums) {
            int len = nums.length;
            if (len < 3){
                return false;
            }
            int[] min = new int[len]; // the min number before ith element
            int curMin = nums[0];
            for (int i = 1; i < len; i++){
                curMin = Math.min(curMin, nums[i - 1]);
                min[i] = curMin;
            }
            Stack<Integer> stack = new Stack<>();// monotonic decreasing
            stack.push(nums[len - 1]);
            for (int i = len - 2; i >= 1; i--){
                if (nums[i] > min[i]){
                    while(!stack.isEmpty() && stack.peek() <= nums[i]){
                        if (stack.peek() < nums[i]){
                            if (min[i] < stack.peek()){
                                return true;
                            }
                        }
                        stack.pop();
                    }
                    stack.push(nums[i]);
                }
            }
            return false;
        }
    }
}