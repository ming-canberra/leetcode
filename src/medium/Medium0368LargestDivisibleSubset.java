package medium;

import java.util.*;

public class Medium0368LargestDivisibleSubset {
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

    class Solution1 {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            Arrays.sort(nums);
            int len = nums.length;
            int[][] dp = new int[len][2]; // 0th for length, 1th for previous index;
            int indexLargest = 0;
            for (int i = 0; i < len; i++){
                int curLargest = 1;
                int indexPrevLargest = 0;
                for (int j = 0; j < i; j++){
                    if (nums[i] % nums[j] == 0){
                        if (curLargest < dp[j][0] + 1){
                            curLargest = dp[j][0] + 1;
                            indexPrevLargest = j;
                        }
                    }
                }
                dp[i][0] = curLargest;
                dp[i][1] = indexPrevLargest;
                if (curLargest > dp[indexLargest][0]){
                    indexLargest = i;
                }
            }
            List<Integer> result = new ArrayList<>();
            while(dp[indexLargest][0] != 1){
                result.add(nums[indexLargest]);
                indexLargest = dp[indexLargest][1];
            }
            result.add(nums[indexLargest]);
            return result;
        }
    }

    class Solution2 {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            Arrays.sort(nums);
            Map<Integer, List<Integer>> map = new HashMap<>();
            Integer resEndingInteger = nums[0];
            for (int value : nums) {
                List<Integer> list = new ArrayList<>();
                list.add(value);
                map.put(value, list);
            }
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] % nums[j] == 0) {
                        if (map.get(nums[j]).size() + 1 >  map.get(nums[i]).size()) {
                            List<Integer> list = new ArrayList<>(map.get(nums[j]));
                            list.add(nums[i]);
                            map.put(nums[i], list);
                            if (list.size() > map.get(resEndingInteger).size()) {
                                resEndingInteger = nums[i];
                            }
                        }
                    }
                }
            }
            return map.get(resEndingInteger);
        }
    }
}