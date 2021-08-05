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
}