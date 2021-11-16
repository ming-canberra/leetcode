package medium;

import java.util.*;
public class Medium1248CountNumberofNiceSubarrays {
    class Solution {
        public int numberOfSubarrays(int[] nums, int k) {
            int left = 0;
            int nextOddIdx = 0;
            int count = 0;
            List<Integer> oddIdxList = new ArrayList<>();
            int idxOfNextOdd = 0;
            for (int i = 0; i < nums.length; i++){
                if (nums[i] % 2 == 1){
                    oddIdxList.add(i);
                    k--;
                }
                if (k <= 0){
                    if (k < 0){
                        left = oddIdxList.get(idxOfNextOdd) + 1;
                        idxOfNextOdd++;
                        k++;
                    }
                    if (k == 0){
                        count += (oddIdxList.get(idxOfNextOdd) - left + 1);
                    }
                }
            }
            return count;
        }
    }
}