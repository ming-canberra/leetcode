package medium;

import java.util.*;

public class CoinChange322 {
    public static void main(String[] args) {
        CoinChange322 thisClass = new CoinChange322();

        int res = thisClass.coinChange(new int[]{1,2,5}, 11);
        System.out.println(res);
    }

    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            int min = -1;
            for (int j : coins) {
                int currentMin;
                if (i - j == 0) {
                    dp[i] = 1;
                    break;
                } else if (i - j > 0 && dp[i - j] != -1) {
                    currentMin = 1 + dp[i - j];
                    if (min != -1) {
                        min = Math.min(min, currentMin);
                    } else {
                        min = currentMin;
                    }
                }
            }
            if (dp[i] != 1){
                dp[i] = min;
            }
        }

        return dp[amount];
    }

    class Solution {
        public int coinChange(int[] coins, int amount) {
            Arrays.sort(coins);
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, -1);
            dp[0] = 0;
            for (int i = 1; i < dp.length; i++){
                Integer min = null;
                for (int j = 0; j < coins.length; j++){
                    if (i - coins[j] >= 0){
                        if (dp[i - coins[j]] != -1){
                            if (min == null){
                                min = dp[i - coins[j]];
                            }
                            else{
                                min = Math.min(min, dp[i - coins[j]]);
                            }
                        }
                    }
                }
                if (min != null){
                    dp[i] = min + 1;
                }
            }
            return dp[amount];
        }
    }

    class Solution1 {
        public int coinChange(int[] coins, int amount) {
            Integer[] dp = new Integer[amount + 1];
            dp[0] = 0;
            for (int i = 1; i < dp.length; i++){
                int min = Integer.MAX_VALUE;
                for (int j = coins.length - 1; j >= 0; j--){
                    if(i - coins[j] >= 0){
                        if(dp[i - coins[j]] != null){
                            min = Math.min(min, dp[i - coins[j]] + 1);
                        }
                    }
                }
                if (min != Integer.MAX_VALUE){
                    dp[i] = min;
                }
            }
            return dp[amount] == null ? -1 : dp[amount];
        }
    }

    class Solution2 {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            dp[0] = 0;
            for (int i = 1; i <= amount; i++){
                dp[i] = -1;
                Integer min = null;
                for (int cn : coins){
                    if (i == cn){
                        dp[i] = 1;
                        break;
                    }
                    else if (i > cn){
                        if (dp[i - cn]  > 0){
                            if (min == null){
                                min = dp[i - cn] + 1;
                            }
                            else{
                                min = Math.min(min, dp[i - cn] + 1);
                            }
                            dp[i] = min;
                        }
                    }
                }
            }
            return dp[amount];
        }
    }
}