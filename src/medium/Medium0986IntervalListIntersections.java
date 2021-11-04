package medium;

import java.util.*;

public class Medium0986IntervalListIntersections {
    /**
     * O( (M + N) * log(M + N) );
     */
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

    /**
     * O(M + N);
     */
    class Solution1{
        public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
            int fIndex = 0;
            int sIndex = 0;
            List<int[]> result = new ArrayList<>();
            while(fIndex < firstList.length && sIndex < secondList.length){
                if (firstList[fIndex][0] > secondList[sIndex][1]){
                    sIndex++;
                }
                else if (secondList[sIndex][0] > firstList[fIndex][1]){
                    fIndex++;
                }
                else{
                    result.add(new int[]{Math.max(firstList[fIndex][0], secondList[sIndex][0]), Math.min(secondList[sIndex][1], firstList[fIndex][1])});
                    if (firstList[fIndex][1] < secondList[sIndex][1]){
                        fIndex++;
                    }
                    else{
                        sIndex++;
                    }
                }
            }
            int[][] rArray = new int[result.size()][2];
            int tmpIdx = 0;
            for (int[] item : result){
                rArray[tmpIdx++] = item;
            }
            return rArray;
        }
    }

}