package medium;

import java.util.Arrays;

public class Medium0453MinimumMovesToEqualArrayElements {
    class Solution {
        public int minMoves(int[] nums) {
            Arrays.sort(nums);
            int rlt = 0;
            for (int i = 1; i < nums.length; i++){
                rlt += nums[i] - nums[0];
            }
            return rlt;
        }
    }
}