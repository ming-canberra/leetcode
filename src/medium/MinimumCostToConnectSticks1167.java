package medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumCostToConnectSticks1167 {
    public static void main(String[] args) {
        MinimumCostToConnectSticks1167 thisClass = new MinimumCostToConnectSticks1167();
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

    public int connectSticks2(int[] sticks) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i : sticks){
            queue.add(i);
        }

        int result = 0;

        while (queue.size() != 1){
            Integer a = queue.poll();
            Integer b = queue.poll();
            result += (a + b);
            queue.add(a + b);
        }
        return result;
    }
}