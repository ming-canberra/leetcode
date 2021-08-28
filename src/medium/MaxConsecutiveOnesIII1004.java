package medium;

public class MaxConsecutiveOnesIII1004 {
    class Solution {
        public int longestOnes(int[] nums, int k) {
            int l = 0;
            int result = 0;
            for (int r = 0; r < nums.length; r++){
                if (nums[r] == 0){
                    if (k > 0){
                        k--;
                    }
                    else{
                        // move left until it frees up a zero
                        while(l <= r && nums[l] != 0){
                            l++;
                        }
                        l++;
                    }
                }
                result = Math.max(result, r - l + 1);
            }
            return result;
        }
    }
}