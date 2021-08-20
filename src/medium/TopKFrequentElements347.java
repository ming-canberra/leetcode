package medium;

import java.util.*;

public class TopKFrequentElements347 {
    /**
     * O(N + M*Log(M + 1 - K))
     * */
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++){
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            int[] result = new int[k];
            int n = map.size();
            PriorityQueue<int[]> heap = new PriorityQueue<>(new MyCom());
            int index = 1;
            for (int key : map.keySet()){
                int value = map.get(key);
                heap.add(new int[]{key, value});
                if (index > n - k){
                    result[index - n + k - 1] = heap.poll()[0];
                }
                index++;
            }
            return result;
        }
        /**map heap counting occurances of unique element*/
        class MyCom implements Comparator<int[]>{
            @Override
            public int compare(int[] a, int[] b){
                return Integer.compare(b[1], a[1]);
            }
        }
    }

    class Solution1 {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int intV : nums){
                map.put(intV, map.getOrDefault(intV, 0) + 1);
            }
            PriorityQueue<int[]> heap = new PriorityQueue<>( (a, b)->a[1] - b[1] );// min heap
            for (Object o : map.keySet()){
                heap.add(new int[]{(Integer)o, map.get(o)});
                if (heap.size() > k){
                    heap.poll();
                }
            }
            int[] result = new int[k];
            for (int i = 0; i < k; i++){
                result[i] = heap.poll()[0];
            }
            return result;
        }
    }
}