package medium;

import java.util.*;

public class Medium0986IntervalListIntersections {
    class Solution {
        public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
            List<int[]> result = new ArrayList<>();
            PriorityQueue<int[]> queue = new PriorityQueue<>( (a, b)-> a[0] - b[0] );
            for (int[] item : firstList){
                queue.add(item);
            }
            for (int[] item : secondList){
                queue.add(item);
            }
            int[] head = queue.poll();
            int start = head[0];
            int end = head[1];
            while(!queue.isEmpty()){
                int[] top = queue.poll();
                if (top[0] <= end){
                    result.add(new int[]{top[0], Math.min(top[1], end)});
                    if (top[1] > end){
                        end = top[1];
                        start = top[0];
                    }
                }
                else{
                    start = top[0];
                    end = top[1];
                }
            }
            int[][] tmp = new int[result.size()][2];
            int tmpIdx = 0;
            for (int[] a : result){
                tmp[tmpIdx++] = a;
            }
            return tmp;
        }
    }
}