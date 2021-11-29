package medium;

import java.util.*;

public class Medium0915PartitionArrayintoDisjointIntervals {
    class Solution {
        public int partitionDisjoint(int[] nums) {
            int len = nums.length;
            int[] mins = new int[len];
            int curMin = nums[len - 1];
            for (int i = len - 1; i >= 0; i--){
                curMin = Math.min(curMin, nums[i]);
                mins[i] = curMin;
            }
            int curMax = nums[0];
            for (int i = 0; i < len - 1; i++){
                curMax = Math.max(curMax, nums[i]);
                if (curMax <= mins[i + 1]){
                    return i + 1;
                }
            }
            return 1;
        }
    }
}