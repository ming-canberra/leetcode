package easy;

import java.util.Arrays;

public class RemoveDuplicatesfromSortedArray26 {
    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length == 0){
                return 0;
            }
            int prev = nums[0];
            int curIndex = 0;
            for (int i = 1; i < nums.length; i++){
                if (prev != nums[i]){
                    curIndex++;
                    nums[curIndex] = nums[i];
                }
                prev = nums[i];
            }
            return curIndex + 1;
        }
    }
}