package medium;

import java.util.*;

public class Medium1229MeetingScheduler {
    class Solution {
        public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
            List<Integer> result = new ArrayList<>();
            PriorityQueue<int[]> heap = new PriorityQueue<>( (a, b)->a[0] - b[0] );
            for (int[] s : slots1){
                heap.add(s);
            }
            for (int[] s : slots2){
                heap.add(s);
            }
            int[] firstOne = heap.poll();
            int start = firstOne[0];
            int end = firstOne[1];
            while( !heap.isEmpty() ){
                int[] top = heap.poll();
                if (top[0] < end){
                    if (Math.min(end, top[1]) - top[0] >= duration){
                        result.add(top[0]);
                        result.add(top[0] + duration);
                        return result;
                    }
                }
                if (top[1] >= end){
                    start = top[0];
                    end = top[1];
                }
            }
            return result;
        }
    }
}