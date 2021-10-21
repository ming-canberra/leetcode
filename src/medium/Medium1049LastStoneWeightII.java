package medium;

import java.util.*;

public class Medium1049LastStoneWeightII {
    class Solution {
        public int lastStoneWeightII(int[] stones) {
            int len = stones.length;
            int sum = 0;
            for (int i : stones){
                sum += i;
            }
            int maxSum = sum / 2;
            boolean[][] dp = new boolean[len][maxSum + 1];
            for (int i = 0; i < len; i++){
                for (int j = 0; j < maxSum + 1; j++){
                    if (i != 0){
                        if (j - stones[i] >= 0){
                            dp[i][j] = dp[i - 1][j] || dp[i - 1][j - stones[i]];
                        }
                        else{
                            dp[i][j] = dp[i - 1][j];
                        }
                    }
                    if (j == stones[i]){
                        dp[i][j] = true;
                    }
                }
            }
            for (int k = maxSum; k >= 0; k--){
                if (dp[len - 1][k]){
                    return sum - k - k;
                }
            }
            return stones[0];
        }
    }
}