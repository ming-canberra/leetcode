package medium;

import java.util.HashMap;

public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        ShortestUnsortedContinuousSubarray thisClass = new ShortestUnsortedContinuousSubarray();
        System.out.println (thisClass.findUnsortedSubarray(new int[]{1,5,3,2,4}));
    }
    public int findUnsortedSubarray(int[] nums) {
        int lIndexOutOfOrder = -1;
        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] < nums[i - 1])
            {
                lIndexOutOfOrder = i - 1;
                break;
            }
        }
        if (lIndexOutOfOrder == -1){
            return 0;
        }
        int rIndexOutOfOrder = 0;
        for (int i = nums.length - 2; i >= 0; i--){
            if (nums[i] > nums[i + 1]){
                rIndexOutOfOrder = i + 1;
                break;
            }
        }
        int maxOutOfOrder = nums[rIndexOutOfOrder];
        int minOutofOrder = nums[rIndexOutOfOrder];
        for (int i = lIndexOutOfOrder; i <= rIndexOutOfOrder ; i++){
            maxOutOfOrder = Math.max(maxOutOfOrder, nums[i]);
            minOutofOrder = Math.min(minOutofOrder, nums[i]);
        }
        int lResultIndex = 0;
        int rResultIndex = nums.length - 1;
        for (int i = lIndexOutOfOrder; i >= 0; i--){
            if (nums[i]<=minOutofOrder){
                lResultIndex = i + 1;
                break;
            }
        }
        for (int i = rIndexOutOfOrder; i < nums.length; i++){
            if (nums[i]>=maxOutOfOrder){
                rResultIndex = i - 1;
                break;
            }
        }
        return rResultIndex - lResultIndex + 1;
    }
}