package medium;

import java.util.*;

public class Triangle120 {
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();
            int[][] dp = new int[n][n];
            int result = Integer.MAX_VALUE;
            dp[0][0] = triangle.get(0).get(0);
            if (n == 1){
                return dp[0][0];
            }
            for (int i = 1; i < n; i++){
                for (int j = 0; j <= i; j++){
                    if (j == 0){
                        dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                    }
                    else if (j == i){
                        dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                    }
                    else{
                        dp[i][j] = Math.min(dp[i - 1][j - 1] + triangle.get(i).get(j), dp[i - 1][j] + triangle.get(i).get(j));
                    }

                    if (i == n - 1){
                        result = Math.min(result, dp[i][j]);
                    }
                }
            }
            return result;
        }
    }
}