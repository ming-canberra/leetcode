package medium;

import java.util.*;
public class Medium0128LongestConsecutiveSequence {
    class Solution {
        public int longestConsecutive(int[] nums) {
            int result = 0;

            Map<Integer, int[]> map = new HashMap<>();

            for (int iValue : nums){
                if (!map.containsKey(iValue)){

                    int max = iValue;
                    int min = iValue;
                    if (map.containsKey(iValue + 1)){
                        max = map.get(map.get(iValue + 1)[1])[1];
                    }
                    if (map.containsKey(iValue - 1)){
                        min = map.get(map.get(iValue - 1)[0])[0];
                    }

                    if (map.containsKey(iValue + 1)){
                        map.put(map.get(iValue + 1)[1], new int[]{min, max});
                    }

                    if (map.containsKey(iValue - 1)){
                        map.put(map.get(iValue - 1)[0], new int[]{min, max});
                    }

                    map.put(iValue, new int[]{min, max});
                    result = Math.max(result, max - min + 1);
                }
            }
            return result;
        }
    }
}