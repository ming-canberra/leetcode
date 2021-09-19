package medium;

import java.util.*;

public class Medium368LargestDivisibleSubset {
    class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            Arrays.sort(nums);
            int len = nums.length;
            List<List<Integer>> dp = new ArrayList<>();
            for (int i = len; i > 0; i--){
                dp.add(new ArrayList<>());
            }
            int resultSize = 0;
            int resultIndex = 0;
            for (int i = 0; i < len; i++){
                List<Integer> curList = dp.get(i);
                for (int j = 0; j < i; j++){
                    if (nums[i] % nums[j] == 0){
                        if (dp.get(j).size() > curList.size()){
                            curList.clear();
                            curList.addAll(dp.get(j));
                        }
                    }
                }
                curList.add(nums[i]);
                if (curList.size() > resultSize){
                    resultSize = curList.size();
                    resultIndex = i;
                }
            }
            if (dp.get(resultIndex).size() == 1){
                new ArrayList<>();
            }
            return  dp.get(resultIndex);
        }
    }
}