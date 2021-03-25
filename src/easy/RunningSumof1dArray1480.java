package easy;

import java.util.Arrays;

public class RunningSumof1dArray1480 {
    public static void main(String[] args) {
        RunningSumof1dArray1480 thisClass = new RunningSumof1dArray1480();

        thisClass.runningSum(new int[] {1,4,3,2});
    }
    //do binary search
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++){
            nums[i] = nums[i-1] + nums[i];
        }
        return nums;
    }
}