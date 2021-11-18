package medium;

import java.util.*;

public class Medium0743NetworkDelayTime {
    /**
     * O(n E)
     *
     * */
    class Solution {
        public int networkDelayTime(int[][] times, int n, int k) {
            int[] nodeTimes = new int[n + 1];
            Arrays.fill(nodeTimes, Integer.MAX_VALUE);

            for (int i = 1; i < n; i++){

                int[] curTimes = new int[n + 1];
                Arrays.fill(curTimes, Integer.MAX_VALUE);

                for (int j = 0; j < times.length; j++){
                    if (i == 1){
                        if (times[j][0] == k){
                            nodeTimes[times[j][1]] = times[j][2];
                        }
                    }
                    else{
                        if (times[j][0] != k){
                            if (nodeTimes[times[j][0]] != Integer.MAX_VALUE){
                                int curTravelTime = times[j][2] + nodeTimes[times[j][0]];
                                curTimes[times[j][1]] = Math.min(curTravelTime, curTimes[times[j][1]]);
                            }
                        }
                    }
                }

                for (int j = 1; j <= n; j++){
                    nodeTimes[j] = Math.min(nodeTimes[j], curTimes[j]);
                }
            }

            int max = 0;

            for (int i = 1; i < n + 1; i++){
                if (i != k){

                    if (nodeTimes[i] == Integer.MAX_VALUE){
                        return -1;
                    }

                    max = Math.max(max, nodeTimes[i]);
                }
            }
            return max;
        }
    }
}