package medium;

import java.util.Arrays;

public class MaximumLengthOfPairChain646 {
    public static void main(String[] args) {
        MaximumLengthOfPairChain646 thisClass = new MaximumLengthOfPairChain646();

        int res = thisClass.findLongestChain(new int[][]{new int[]{2,3}, new int[]{1,2}, new int[]{3,4} });
        System.out.println(res);
    }

    public int findLongestChain(int[][] pairs) {

        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        // represent the index for longest chain ending on it.
        int dp[] = new int[pairs.length];


        dp[0] = 1;

        for (int i = 1; i < dp.length;i++) {
            int temp

        }


            int toReturn = 0;
        for (int i = 0; i < dp.length;i++){
            toReturn = Math.max(toReturn, dp[i]);
        }
        return toReturn;
    }
}