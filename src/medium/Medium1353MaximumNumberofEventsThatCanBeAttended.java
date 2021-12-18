package medium;

import java.util.*;

public class Medium1353MaximumNumberofEventsThatCanBeAttended {
    class Solution {
        public int maxEvents(int[][] events) {
            int count = 0;
            Arrays.sort(events, (a, b)->  a[0] - b[0] );
            PriorityQueue<int[]> heap = new PriorityQueue<int[]>( (a, b)->  a[1] - b[1] ); // min heap on finish time

            heap.add(events[0]);
            int idx = 1;

            for (int day = events[0][0]; day <= 100000; day++){

                while(idx < events.length && events[idx][0] <= day){
                    heap.add(events[idx]);
                    idx++;
                }

                while (!heap.isEmpty()){
                    int[] top = heap.peek();
                    if (day >= top[0] && day <= top[1]){
                        count++;
                        heap.poll();
                        break;
                    }
                    else if (day > top[1] ){
                        heap.poll();
                    }
                }

            }
            return count;
        }
    }
}