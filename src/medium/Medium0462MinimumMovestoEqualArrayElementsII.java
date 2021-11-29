package medium;

import java.util.*;

public class Medium0462MinimumMovestoEqualArrayElementsII {
    class Solution {
        public int minMoves2(int[] nums) {
            Arrays.sort(nums);
            int medium = nums[nums.length / 2];
            int sum = 0;
            for (int num : nums){
                sum += Math.abs(medium - num);
            }
            return sum;
        }
    }
}