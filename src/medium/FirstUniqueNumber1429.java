package medium;

import java.util.*;

public class FirstUniqueNumber1429 {
    class FirstUnique {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        public FirstUnique(int[] nums) {
            for (int i = 0; i < nums.length; i++){
                int mapValue = countMap.getOrDefault(nums[i], 0) + 1;
                countMap.put(nums[i], mapValue);
                if (mapValue == 1){
                    queue.add(nums[i]);
                }
            }
        }
        public int showFirstUnique() {
            while(!queue.isEmpty()){
                int top = queue.peek();
                if (countMap.get(top) > 1){
                    queue.poll();
                }
                else{
                    return top;
                }
            }
            return -1;
        }
        public void add(int value) {
            int mapValue = countMap.getOrDefault(value, 0) + 1;
            countMap.put(value, mapValue);
            if (mapValue == 1){
                queue.add(value);
            }
        }
    }
}