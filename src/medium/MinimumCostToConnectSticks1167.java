package medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumCostToConnectSticks1167 {
    public static void main(String[] args) {
        MinimumCostToConnectSticks1167 thisClass = new MinimumCostToConnectSticks1167();
    }

    /**
     * do it again using heap
     *
    * */
    public int connectSticksHeap(int[] sticks) {
        if (sticks.length == 1){
            return 0;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

        for (int i : sticks){
            heap.add(i);
        }
        int result = 0;

        while(heap.size() > 1){
            int top1 = heap.poll();
            int top2 = heap.poll();
            result+=top1;
            result+=top2;
            heap.add(top1 + top2);
        }

        return result;
    }

    public int connectSticks(int[] sticks) {
        if (sticks.length == 1){
            return 0;
        }

        Arrays.sort(sticks);

        int result = 0;
        int n = sticks.length;

        for ( int i = 1; i < n; i++){
            result += (sticks[i] + sticks[i - 1]);
            sticks[i] += sticks[i - 1];

            Arrays.sort(sticks, i, n);
        }

        return result;
    }

    class Solution {
        public int connectSticks(int[] sticks) {
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            int result = 0;
            for (int i : sticks){
                heap.add(i);
            }
            while (heap.size() > 1){
                int newTop = heap.poll() + heap.poll();
                result += newTop;
                heap.add(newTop);
            }
            return result;
        }
    }
}