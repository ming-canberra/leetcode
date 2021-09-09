package medium;

import java.util.*;

public class Medium256PaintHouse {
    class Solution {
        public int minCost(int[][] costs) {
            int[][] dp = new int[costs.length][3];
            dp[0][0] = costs[0][0];
            dp[0][1] = costs[0][1];
            dp[0][2] = costs[0][2];
            for (int i = 1; i < dp.length; i++){
                dp[i][0] = Math.min( costs[i][0] + dp[i - 1][1],  costs[i][0] + dp[i - 1][2] );
                dp[i][1] = Math.min( costs[i][1] + dp[i - 1][0],  costs[i][1] + dp[i - 1][2] );
                dp[i][2] = Math.min( costs[i][2] + dp[i - 1][0],  costs[i][2] + dp[i - 1][1] );
            }
            int result = Math.min( dp[dp.length - 1][0], dp[dp.length - 1][1] );
            return Math.min( result, dp[dp.length - 1][2] );
        }
    }
}