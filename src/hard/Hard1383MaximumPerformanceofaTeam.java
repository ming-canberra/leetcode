package hard;

import java.util.*;

public class Hard1383MaximumPerformanceofaTeam {

    class Solution {
        public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
            int[][] se = new int[n][2];
            for (int i = 0; i < n; i++){
                se[i] = new int[]{ speed[i], efficiency[i] };
            }
            Arrays.sort(se, (a, b)->b[1] - a[1]); // descending on efficiency
            PriorityQueue<Integer> heap = new PriorityQueue<>();// min heap
            int mod = 1000000007;
            long sum = 0;
            long result = 0;
            for (int i = 0; i < n; i++){
                sum += se[i][0];
                heap.add(se[i][0]);
                if (heap.size() > k){
                    sum -= heap.poll();
                }
                result = Math.max(result, (long)sum * se[i][1] );
            }
            return (int)(result % mod);
        }
    }
}