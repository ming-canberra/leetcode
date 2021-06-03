package medium;

import java.util.*;

public class MaximumSubarrayMinProduct1856 {
    class Solution {
        /**
         * O(N)
         * */
        public int maxSumMinProduct(int[] nums) {
            long[]sums = new long[nums.length + 1];

            sums[0] = 0;
            for (int i = 1; i < nums.length + 1; i++){
                sums[i] = sums[i - 1] + nums[i - 1];

            }

            Stack<int[]> stack = new Stack<>();

            long result = 0;

            for (int i = 0; i < nums.length; i++){
                while(!stack.isEmpty() && stack.peek()[0] > nums[i]){
                    int[] top = stack.pop();
                    int endIndex = 0;
                    if(!stack.isEmpty()){
                        endIndex = stack.peek()[1] + 1;
                    }
                    long minProduct = top[0] * (sums[i] - sums[endIndex]);

                    result = Math.max(result, minProduct);
                }

                stack.push(new int[]{nums[i], i});
            }

            while(!stack.isEmpty()){
                int[] top = stack.pop();

                int endIndex = 0;
                if(!stack.isEmpty()){
                    endIndex = stack.peek()[1] + 1;
                }
                long minProduct = top[0] * (sums[sums.length - 1] - sums[endIndex]);
                result = Math.max(result, minProduct);
            }

            return (int)(result % (1000000000 + 7));
        }
    }
}