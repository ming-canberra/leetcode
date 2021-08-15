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

    class Solution1 {
        public int minimumTotal(List<List<Integer>> triangle) {
            int[] array = new int[triangle.size()];
            for (int i = 0; i < triangle.size(); i++){
                for (int j = triangle.get(i).size() - 1; j >= 0; j--){
                    if (j == 0){
                        array[j] = triangle.get(i).get(j) + array[j];
                    }
                    else if (j == triangle.get(i).size() - 1){
                        array[j] = triangle.get(i).get(j) + array[j - 1];
                    }
                    else{
                        array[j] = triangle.get(i).get(j) + Math.min(array[j - 1], array[j]);
                    }
                }
            }
            Arrays.sort(array);
            return array[0];
        }
    }
}