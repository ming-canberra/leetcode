package easy;

import java.util.ArrayList;
import java.util.List;

public class MinCostClimbingStairs746 {
    public static void main(String[] args) {
        MinCostClimbingStairs746 thisClass = new MinCostClimbingStairs746();

        System.out.println(thisClass.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));

    }
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < cost.length; i++){

            dp[i] = Math.min(cost[i] + dp[i-2], cost[i] + dp[i-1]);
        }


        return Math.min(dp[dp.length -1], dp[dp.length -2]);
    }


}