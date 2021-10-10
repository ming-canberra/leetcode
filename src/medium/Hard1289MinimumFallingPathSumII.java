package medium;

import java.util.*;

public class Hard1289MinimumFallingPathSumII {
    class Solution {
        public int minFallingPathSum(int[][] grid) {
            int result = Integer.MAX_VALUE;
            int len = grid.length;
            int[][] dp = new int[len][len];
            for (int j = 0; j < len; j++){
                dp[0][j] = grid[0][j];
                if (len == 1){
                    result = Math.min(result, dp[0][j]);
                }
            }
            for (int i = 1; i < len; i++){
                int[][] tmpMinArray = new int[len][2];
                for (int j = 0; j < len; j++){
                    tmpMinArray[j] = new int[]{dp[i - 1][j], j};
                }
                Arrays.sort( tmpMinArray, (a, b) -> a[0] - b[0] );// ascending
                for (int j = 0; j < len; j++){
                    int min = tmpMinArray[0][0];
                    if (j == tmpMinArray[0][1]){
                        min = tmpMinArray[1][0];
                    }
                    dp[i][j] = min + grid[i][j];
                    if (i == len - 1){
                        result = Math.min(result, dp[i][j]);
                    }
                }
            }
            return result;
        }
    }
}