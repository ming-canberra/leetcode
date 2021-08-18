package medium;

import java.util.*;

public class ContiguousArray525 {
    class Solution {
        public int findMaxLength(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            int result = 0;
            int count = 0;
            for (int i = 0; i < nums.length; i++){
                if (nums[i] == 0){
                    count--;
                }
                else{
                    count++;
                }
                if (count == 0){
                    result = Math.max(result, i + 1);
                }
                else{
                    if (map.containsKey(count)){
                        result = Math.max(result, i - map.get(count));
                    }
                    else{
                        map.put(count, i);
                    }
                }
            }
            return result;
        }
    }
}