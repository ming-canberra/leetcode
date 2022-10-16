package medium;

public class Medium209MinimumSizeSubarraySum {
    public static void main(String[] args) {
        Medium209MinimumSizeSubarraySum thisClass = new Medium209MinimumSizeSubarraySum();
    }
    /**
     *O(NlogN)
     */
    public int minSubArrayLen(int target, int[] nums) {
        int[] sum = new int[nums.length + 1];

        sum[0] = 0;
        for (int i = 0; i < nums.length; i++){
            sum[1 + i] = nums[i] + sum[i];
        }

        if (sum[sum.length - 1] < target){
            return 0;
        }
        int l = 0;
        int r = nums.length + 1;
        while (l + 1 < r){
            int m = l + (r - l) / 2;
            if (isOK(target, m, sum)){
                r = m;
            }
            else{
                l = m;
            }
        }
        return r;
    }

    private boolean isOK(int target, int length, int[] sum){
        for (int i = length; i < sum.length; i++){
            if (sum[i] - sum[i - length]>= target){
                return true;
            }
        }

        return false;
    }

    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            Integer result = null;
            int l = 0;
            int sum = 0;
            for (int i = 0; i < nums.length; i++){
                sum += nums[i];
                while(sum >= target && l <= i){
                    if (result == null){
                        result = i - l + 1;
                    }
                    else{
                        result = Math.min(result, i - l + 1);
                    }
                    sum -= nums[l];
                    if (l == i){
                        return 1;
                    }
                    l++;
                }
            }
            return result == null ? 0 : result;
        }
    }

    class Solution1 {
        public int minSubArrayLen(int target, int[] nums) {
            int result = Integer.MAX_VALUE;
            int left = 0;
            int sum = 0;
            for (int i = 0; i < nums.length; i++){
                sum += nums[i];
                while(sum >= target){
                    result = Math.min(result, i - left + 1);
                    sum -= nums[left];
                    left++;
                }
            }
            return result == Integer.MAX_VALUE ? 0 : result;
        }
    }

    class Solution2 {
        public int minSubArrayLen(int target, int[] nums) {
            int res = Integer.MAX_VALUE;
            int left = 0;
            int right = - 1;
            int sum = 0;
            while(++right < nums.length) {
                sum += nums[right];
                // move left until sum < target
                while(sum >= target) {
                    res = Math.min(res, right - left + 1);
                    sum -= nums[left];
                    left++;
                }
            }
            return res == Integer.MAX_VALUE ? 0 : res;
        }
    }
}