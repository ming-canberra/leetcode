package medium;

import java.util.*;

public class Medium0442FindAllDuplicatesinanArray {
    class Solution {
        public List<Integer> findDuplicates(int[] nums) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < nums.length; i++){
                int targetIndex = Math.abs(nums[i]) - 1;
                if (nums[targetIndex] < 0){
                    nums[targetIndex] *= -1;
                    result.add(Math.abs(nums[i]));
                }
                else{
                    nums[targetIndex] *= -1;
                }
            }
            return result;
        }
    }
}