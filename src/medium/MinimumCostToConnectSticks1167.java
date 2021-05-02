package medium;

import java.util.Arrays;

public class MinimumCostToConnectSticks1167 {
    private Object HashSet;

    public static void main(String[] args) {
        MinimumCostToConnectSticks1167 thisClass = new MinimumCostToConnectSticks1167();
        System.out.println (thisClass.connectSticks(null));
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
}