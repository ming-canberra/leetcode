package medium;

import java.util.*;

public class MaximumSizeSubarraySumEqualsk325 {
    class Solution {
        public int maxSubArrayLen(int[] nums, int k) {
            int result = 0;
            Map<Integer, Integer> map = new HashMap<>();
            int sum = 0;
            for (int i = 0; i < nums.length; i++){
                sum += nums[i];
                if (sum == k){
                    result = i + 1;
                }
                else{
                    if (map.containsKey(sum - k)){
                        result = Math.max(result, i - map.get(sum - k));
                    }
                }
                map.putIfAbsent(sum, i);
            }
            return result;
        }
    }
}