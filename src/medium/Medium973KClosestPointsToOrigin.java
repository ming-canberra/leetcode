package medium;

import java.util.*;

public class Medium973KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        int[][] disIndex = new int[points.length][2];
        for (int i = 0; i < points.length; i++){
            disIndex[i] = new int[]{points[i][0]*points[i][0] + points[i][1]*points[i][1], i};
        }
        Arrays.sort(disIndex, (a, b)->a[0]-b[0]);
        for (int i = 0; i < k; i++){
            result[i]= points[disIndex[i][1]];
        }
        return result;
    }

    public int[][] kClosest2(int[][] points, int k) {
        Arrays.sort(points, (a, b)-> (a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1]));
        return Arrays.copyOfRange(points, 0, k);
    }

    /**
     * N*log(K)
     * */
    class Solution {
        public int[][] kClosest(int[][] points, int k) {
            PriorityQueue<int[]> maxHeap = new PriorityQueue<>( (a, b) -> b[0]*b[0] + b[1]*b[1] - a[0]*a[0] - a[1]*a[1]);
            for (int i = 0; i < points.length; i++){
                maxHeap.add(points[i]);
                if (maxHeap.size() > k){
                    maxHeap.poll();
                }
            }
            int[][] result = new int[k][2];
            Iterator it = maxHeap.iterator();
            for (int i = 0; i < result.length; i++){
                result[i] = (int[])it.next();
            }
            return result;
        }
    }
}