package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray448 {
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            int n = nums.length;
            List<Integer> result = new ArrayList<>();
            boolean[] existing = new boolean[nums.length + 1];
            for (int i : nums){
                existing[i] = true;
            }
            for (int i = 1; i < existing.length; i++){
                if (!existing[i]){
                    result.add(i);
                }
            }
            return result;
        }
    }

    class SolutionOptimal {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            for (int i = 0; i < nums.length; i++){
                int index = Math.abs(nums[i]) - 1;
                if (nums[index] > 0){
                    nums[index] = -nums[index];
                }
            }
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < nums.length; i++){
                if (nums[i] > 0){
                    result.add(i + 1);
                }
            }
            return result;
        }
    }
}