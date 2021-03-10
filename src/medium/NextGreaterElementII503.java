package medium;

import java.util.Stack;

public class NextGreaterElementII503 {
    public static void main(String[] args) {
        NextGreaterElementII503 thisClass = new NextGreaterElementII503();

        thisClass.nextGreaterElements(null);
    }
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
}