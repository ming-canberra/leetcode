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
    class Solution1 {
        public int minTaps(int n, int[] ranges) {
            int len = n + 1;
            int[][] tapRange = new int[len][2];
            for (int i = 0; i < len; i++){
                tapRange[i] = new int[]{i - ranges[i] < 0 ? 0 : i - ranges[i],  i + ranges[i]};
            }
            Arrays.sort( tapRange, (a, b) -> Integer.compare(a[0], b[0]) );
            int counter = 0;
            int coveredEndPos = 0;
            int tapRangeIdx = 0;
            while(coveredEndPos < n){
                int canReach = -1;
                while(tapRangeIdx < len && tapRange[tapRangeIdx][0] <=  coveredEndPos){
                    canReach = Math.max(canReach, tapRange[tapRangeIdx][1]);
                    tapRangeIdx++;
                }
                if (canReach <= coveredEndPos){
                    return -1;
                }
                coveredEndPos = canReach;
                counter++;
            }
            return counter;
        }
    }
}