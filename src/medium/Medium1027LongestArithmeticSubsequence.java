package medium;

import java.util.*;

public class Medium1027LongestArithmeticSubsequence {
    class Solution {
        public int longestArithSeqLength(int[] nums) {
            int result = 2;
            int len = nums.length;
            HashMap<Integer, Integer>[] dp = new HashMap[len];
            for (int i = 0; i < len; i++){
                HashMap<Integer, Integer> curMap = new HashMap<>();// from diff to count
                for (int j = 0; j < i; j++){
                    int diff = nums[i] - nums[j];
                    if (dp[j].containsKey(diff))
                    {
                        int max = dp[j].get(diff) + 1;
                        if (curMap.containsKey(diff)){
                            max = Math.max(curMap.get(diff), max);
                        }
                        curMap.put(diff, max);
                        result = Math.max(result, max);
                    }
                    else{
                        curMap.putIfAbsent(diff, 2);
                    }
                }
                dp[i] = curMap;
            }
            return result;
        }
    }

    class Solution1 {
        public int longestArithSeqLength(int[] nums) {
            List<Map<Integer, Integer>> mapList = new ArrayList<>();
            int result = 2;
            for (int i = 0; i < nums.length; i++){
                Map<Integer, Integer> map = new HashMap<>();// diff as key, count as value
                mapList.add(map);
                for (int j = 0; j < i; j++){
                    int diff = nums[i] - nums[j];
                    int diffCount = mapList.get(i).getOrDefault(diff, 2);

                    if ( mapList.get(j).containsKey(diff) ){
                        diffCount = Math.max(diffCount, mapList.get(j).get(diff) + 1);
                    }
                    result = Math.max(result, diffCount);
                    mapList.get(i).put(diff, diffCount);
                }
            }
            return result;
        }
    }
}