package medium;

import java.util.*;

public class Medium0983MinimumCostForTickets {
    class Solution {
        public int mincostTickets(int[] days, int[] costs) {
            int[] dp = new int[days.length + 1];
            dp[0] = 0;
            int cost1 = costs[0];
            int cost7 = costs[1];
            int cost30 = costs[2];
            int costMin = Math.min(Math.min(cost1, cost7), cost30);
            for (int i = 1; i < dp.length; i++){
                int option1 = costMin + dp[i - 1];
                int option2 = Integer.MAX_VALUE;
                for (int j = 1; j < i; j++){
                    if (days[i - 1] - days[j - 1] < 7){
                        option2 = dp[j - 1] + Math.min(cost30, cost7);
                        break;
                    }
                }
                int option3 = Integer.MAX_VALUE;
                for (int j = 1; j < i; j++){
                    if (days[i - 1] - days[j - 1] < 30){
                        option3 = dp[j - 1] + cost30;
                        break;
                    }
                }
                dp[i] = Math.min(Math.min(option1, option2), option3);
            }
            return dp[dp.length - 1];
        }
    }

    class Solution1 {
        public int mincostTickets(int[] days, int[] costs) {
            Set<Integer> set = new HashSet<>();
            int lastDay = 0;
            for (int i : days){
                set.add(i);
                lastDay = Math.max(lastDay, i);
            }
            int[] dp = new int[lastDay + 1];
            dp[0] = 0;
            int cost1 = costs[0];
            int cost7 = costs[1];
            int cost30 = costs[2];
            for (int i = 1; i < dp.length; i++){
                int min = Integer.MAX_VALUE;
                if (set.contains(i)){
                    if (i - 1 >= 0){
                        min = Math.min(min, dp[i - 1] + Math.min(cost1, Math.min(cost7, cost30)) );
                    }
                    if (i - 7 >= 0){
                        min = Math.min(min, dp[i - 7] + Math.min(cost7, cost30));
                    }
                    else{
                        min = Math.min(min, Math.min(cost7, cost30));
                    }
                    if (i - 30 >= 0){
                        min = Math.min(min, dp[i - 30] + cost30);
                    }
                    else{
                        min = Math.min(min, cost30);
                    }
                }
                else{
                    min = dp[i - 1];
                }
                dp[i] = min;
            }
            return dp[lastDay];
        }
    }
}