package medium;

import java.util.*;

public class Medium1155NumberofDiceRollsWithTargetSum {
    class Solution {
        private int MOD = 1000000007;
        public int numRollsToTarget(int d, int f, int target) {
            int dp[][] = new int[d + 1][target + 1];
            for (int i = 1; i < d + 1; i++){
                for (int j = 1; j < target + 1; j++){
                    if (i == 1){
                        if (j <= f){
                            dp[i][j] = 1;
                        }
                    }
                    else{
                        int sum = 0;
                        for (int k = 1; k <= f; k++){
                            if (j - k > 0){
                                sum = (sum + dp[i - 1][j - k]) % MOD;
                            }
                        }
                        dp[i][j] = sum;
                    }
                }
            }
            return dp[d][target];
        }
    }
}