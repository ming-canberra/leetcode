package medium;

import java.util.*;

public class NextGreaterElementII503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] toReturn = new int[nums.length];
        int max = Integer.MIN_VALUE;
        Stack<Integer> theStack = new Stack<Integer>();

        //first traverse
        for (int i = 0; i < nums.length;i++) {
            while (!theStack.isEmpty() && nums[i]>nums[theStack.peek()]) {
                int resultIndex = theStack.pop();
                toReturn[resultIndex] = nums[i];
            }
            theStack.push(i);
            max = Math.max(max, nums[i]);
        }
        //second traverse
        for (int i = 0; i < nums.length;i++) {
            if (nums[i] == max){
                while (!theStack.isEmpty()) {
                    int resultIndex = theStack.pop();
                    if (max ==nums[resultIndex]){
                        toReturn[resultIndex] = -1;
                    }
                    else{
                        toReturn[resultIndex] = max;
                    }
                }
            }
            else {
                while (!theStack.isEmpty() && nums[i] > nums[theStack.peek()]) {
                    int resultIndex = theStack.pop();
                    toReturn[resultIndex] = nums[i];
                }
            }
        }


        return toReturn;
    }

    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int[] eNums = new int[nums.length * 2];

            for (int i = 0; i < nums.length; i++){
                eNums[i] = nums[i];
                eNums[i + nums.length] = nums[i];
            }

            int[] result = new int[nums.length];

            Stack<Integer> stack = new Stack<>();

            for (int i = eNums.length - 1; i >= 0; i--){
                while(!stack.isEmpty() && eNums[i] >= stack.peek()){
                    stack.pop();
                }
                if (i < result.length){
                    if (stack.isEmpty()){
                        result[i] = -1;
                    }
                    else{
                        result[i] = stack.peek();
                    }
                }

                stack.add(eNums[i]);
            }

            return result;
        }
    }
}