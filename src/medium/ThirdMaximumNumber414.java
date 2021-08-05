package medium;

import java.util.Arrays;

class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int counter = 1;
        int curVal = nums[nums.length - 1];
        for (int i = nums.length - 2;i >= 0; i--){
            if (nums[i] < curVal){
                counter++;
                curVal = nums[i];
            }
            if (counter == 3){
                return curVal;
            }
        }
        return nums[nums.length - 1];
    }
}