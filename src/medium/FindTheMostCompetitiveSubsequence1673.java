package medium;

import java.util.*;

public class FindTheMostCompetitiveSubsequence1673 {
    class Solution {
        /**
         * O(NLogN)
         *
         * */
        public int[] mostCompetitive(int[] nums, int k) {
            int[] result = new int[k];
            int n = nums.length;
            PriorityQueue<int[]> heap = new PriorityQueue<>(new MyCom());
            int lastIndex = -1;
            int resultIndex = 0;
            for (int i = 0; i < n; i++){
                heap.add(new int[]{nums[i], i});
                if (i >= n - k){
                    while(heap.peek()[1] <= lastIndex){
                        heap.poll();
                    }
                    lastIndex = heap.peek()[1];
                    result[resultIndex] = heap.poll()[0];
                    resultIndex++;
                }
            }
            return result;
        }

        /**
         * sort on value first, index second
         */
        class MyCom implements Comparator<int[]>{
            @Override
            public int compare(int[] a, int[] b){
                if (a[0] == b[0]){
                    return Integer.compare(a[1], b[1]);
                }
                else{
                    return Integer.compare(a[0], b[0]);
                }
            }
        }
    }
}