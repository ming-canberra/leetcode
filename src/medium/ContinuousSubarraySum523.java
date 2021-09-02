package medium;

import java.util.*;

public class ContinuousSubarraySum523 {
    class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {
            Set<Integer> set = new HashSet<>();
            int n = nums.length;
            if (n < 2){
                return false;
            }
            int curSum = nums[0] % k;
            int preSum = curSum;
            for (int i = 1; i < n; i++){
                curSum += nums[i];
                curSum = curSum % k;
                if (curSum == 0){
                    return true;
                }
                if (set.contains(curSum)){
                    return true;
                }
                set.add(preSum);
                preSum = curSum;
            }

            return false;
        }
    }

    class Solution1 {
        public boolean checkSubarraySum(int[] nums, int k) {
            int len = nums.length;
            int sum = nums[0] % k;
            Set<Integer> set = new HashSet<>();
            int prSum = 0;
            for (int i = 1; i < len; i++){
                prSum = sum;
                sum += nums[i];
                sum = sum % k;
                if (sum == 0){
                    return true;
                }
                if (set.contains(sum) ){
                    return true;
                }
                set.add(prSum);
            }
            return false;
        }
    }
}