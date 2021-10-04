package medium;

import java.util.*;

public class Medium1218LongestArithmeticSubsequenceofGivenDifference {
    class Solution {
        public int longestSubsequence(int[] arr, int difference) {
            int result = 1;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++)
            {
                if (map.containsKey(arr[i] - difference)){
                    int tmpMax = map.get(arr[i] - difference) + 1;
                    if (map.containsKey(arr[i])){
                        int max = Math.max(tmpMax, map.get(arr[i]));
                        map.put(arr[i], max);
                    }
                    else{
                        map.put(arr[i], tmpMax);
                    }
                    result = Math.max(result, map.get(arr[i]));
                }
                else{
                    map.putIfAbsent(arr[i], 1);
                }
            }
            return result;
        }
    }
}