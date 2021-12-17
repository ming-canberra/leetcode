package hard;

import java.util.*;

public class Hard0992SubarrayswithKDifferentIntegers {
    class Solution {
        public int subarraysWithKDistinct(int[] nums, int k) {
            return numAtMostK(nums, k) - numAtMostK(nums, k - 1);
        }
        private int numAtMostK(int[] nums, int k){
            if (k == 0){
                return 0;
            }
            int count = 0;
            Map<Integer, Integer> map = new HashMap<>();
            int left = 0;
            for (int i = 0; i < nums.length; i++){
                if (map.size() == k && !map.containsKey(nums[i])){
                    while(map.size() == k){
                        map.put(nums[left], map.get(nums[left]) - 1);
                        if (map.get(nums[left]) == 0){
                            map.remove(nums[left]);
                        }
                        left++;
                    }
                }
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                count += (i - left + 1);
            }
            return count;
        }
    }
}