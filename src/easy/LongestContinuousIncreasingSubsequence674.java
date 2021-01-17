package easy;

import java.util.ArrayList;
import java.util.List;

public class LongestContinuousIncreasingSubsequence674 {
    public static void main(String[] args) {
        LongestContinuousIncreasingSubsequence674 thisClass = new LongestContinuousIncreasingSubsequence674();

        int[] input = new int[]{2,2,2};
        System.out.println(thisClass.findLengthOfLCIS(input));
    }
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0){
            return 0;
        }

        int toReturn = 1;

        int counter = 1;
        for (int i=1;i<nums.length;i++){
            if (nums[i]>nums[i-1]){
                counter++;
            }
            else{
                toReturn = Math.max(toReturn, counter);
                counter =1;
            }
        }
        toReturn = Math.max(toReturn, counter);

        return toReturn;
    }
}