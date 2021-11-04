package medium;

public class Medium795NumberofSubarrayswithBoundedMaximum {

    class Solution {
        public int numSubarrayBoundedMax(int[] nums, int left, int right) {
            int lIndex = 0;
            int count = 0;
            int curMax = nums[lIndex];
            int lastEligibleIndex = nums[lIndex];
            for (int i = 0; i < nums.length; i++){
                curMax = Math.max(curMax, nums[i]);
                if (nums[i] >= left && nums[i] <= right ){
                    lastEligibleIndex = i;
                }
                if (curMax > right){
                    // start over
                    lIndex = i + 1;
                    if (lIndex < nums.length){
                        curMax = nums[lIndex];
                    }
                }
                else if (curMax < left){
                    // current window is ineligible
                }
                else{
                    // current ith is between left and right?
                    if (nums[i] >= left && nums[i] <= right ){
                        count += (i - lIndex + 1);
                    }
                    else{
                        count += (lastEligibleIndex - lIndex + 1);
                    }
                }
            }
            return count;
        }
    }
}