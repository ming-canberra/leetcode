package hard;

import java.util.*;

public class Hard1326MinimumNumberofTapstoOpentoWateraGarden {
    class Solution {
        public int minTaps(int n, int[] ranges) {
            PriorityQueue<int[]> heap = new PriorityQueue<>( (a, b)-> a[0] - b[0] ); //min heap, sort on first element
            for (int i = 0; i < ranges.length; i++){
                if (ranges[i] == 0){
                    continue;
                }
                int start = i - ranges[i];
                int end = i + ranges[i];
                heap.add(new int[]{start, end});
            }

            int count = 0;
            int gIdx = 0;

            while(gIdx <= n){
                int maxEnd = gIdx;
                while(!heap.isEmpty() && heap.peek()[0] <= gIdx )
                {
                    maxEnd = Math.max(maxEnd, heap.poll()[1]);
                }
                if (maxEnd == gIdx){
                    return - 1;
                }

                count++;
                if (maxEnd >= n){
                    return count;
                }

                gIdx = maxEnd;
            }
            return count;
        }
    }

}