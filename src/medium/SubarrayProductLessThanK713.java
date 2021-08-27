package medium;

public class SubarrayProductLessThanK713 {
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            int result = 0;
            int right = 0;
            int prod = 1;
            for (int left = 0; left < nums.length; left++){
                right = Math.max(right, left);
                if (nums[left] >= k){
                    prod = 1;
                    continue;
                }
                while(right < nums.length && prod * nums[right] < k){
                    prod = prod * nums[right];
                    right++;
                }
                result += (right - left);
                prod = prod / nums[left];
            }
            return result;
        }
    }
}