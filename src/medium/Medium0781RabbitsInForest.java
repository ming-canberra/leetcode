package medium;

import java.util.*;

public class Medium0781RabbitsInForest {
    class Solution {
        public int numRabbits(int[] answers) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int value : answers){
                map.putIfAbsent(value, 0);
                map.put(value, map.get(value) + 1);
            }
            int result = 0;
            for (int key : map.keySet()){
                int count = map.get(key);
                result += (count + key) / (key + 1) * (key + 1);
            }
            return result;
        }
    }
}