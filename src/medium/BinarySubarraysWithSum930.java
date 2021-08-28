package medium;

import java.util.*;

public class BinarySubarraysWithSum930 {
    class Solution {
        public int numSubarraysWithSum(int[] nums, int goal) {
            int n = nums.length;
            int[] sums = new int[n];
            sums[0] = nums[0];
            for (int i = 1; i < n; i++){
                sums[i] = sums[i - 1] + nums[i];
            }
            int result = 0;
            Map<Integer, Integer> map = new HashMap<>();//sum to count
            for (int i = 0; i < n; i++){
                result += map.getOrDefault(sums[i] - goal, 0);
                map.put(sums[i], map.getOrDefault(sums[i], 0) + 1);
                if (sums[i] == goal){
                    result++;
                }
            }
            return result;
        }
    }
}