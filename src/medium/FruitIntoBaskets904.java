package medium;

import java.util.*;

public class FruitIntoBaskets904 {
    class Solution {
        public int totalFruit(int[] fruits) {
            Map<Integer, Integer> map = new HashMap<>();
            int left = 0;
            int result = 1;
            for (int right = 0; right < fruits.length; right++){
                if (map.containsKey(fruits[right])){
                    map.put(fruits[right], map.get(fruits[right]) + 1);
                }
                else{
                    // add this fruit to basket, empty one basket first by moving left index
                    if (map.size() == 2){
                        // move left to remove 1 key from map, i.e. empty 1 basket
                        while(left < right){
                            if (map.get(fruits[left]) == 1 ){
                                map.remove(fruits[left]);
                                left++;
                                break;
                            }
                            else{
                                map.put(fruits[left], map.get(fruits[left]) - 1);
                                left++;
                            }
                        }
                    }
                    map.put(fruits[right], 1);
                }
                result = Math.max(result, right - left + 1);
            }
            return result;
        }
    }
}