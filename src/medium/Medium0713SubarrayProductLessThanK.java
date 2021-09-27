package medium;

public class Medium0713SubarrayProductLessThanK {
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

    class Solution1 {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            if (k == 0 || k == 1){
                return 0;
            }
            int result = 0;
            int left = 0;
            int prod = 1;
            for (int right = 0; right < nums.length; right++){
                prod = prod * nums[right];
                while(prod >= k){
                    prod = prod / nums[left];
                    left++;
                }
                result += right - left + 1;
            }
            return result;
        }
    }

    class Solution2 {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            if (k <= 1){
                return 0;
            }
            int left = 0;
            int prod = 1;
            int result = 0;
            for (int i = 0; i < nums.length; i++){
                prod *= nums[i];
                while (prod >= k){
                    prod = prod / nums[left];
                    left++;
                }
                result += i - left + 1;
            }
            return result;
        }
    }
}