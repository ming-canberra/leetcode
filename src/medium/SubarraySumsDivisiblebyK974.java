package medium;

import java.util.*;

public class SubarraySumsDivisiblebyK974 {
    class Solution {
        public int subarraysDivByK(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>(); // modulo to count
            int sum = 0;
            int result = 0;
            for (int i = 0; i < nums.length; i++){
                sum += nums[i];
                sum = sum % k;
                if (sum < 0){
                    sum += k;
                }
                if (sum == 0){
                    result++;
                }
                if (map.containsKey(sum)){
                    result += map.get(sum);
                }
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return result;
        }
    }
}