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
}