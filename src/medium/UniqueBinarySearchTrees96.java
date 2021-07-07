package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class UniqueBinarySearchTrees96 {
    class Solution {
        public int numTrees(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i < n + 1; i++){
                int sum = 0;
                for (int j = 0; j < i; j++){
                    sum += dp[j] * dp[i - 1 - j];
                }
                dp[i] = sum;
            }
            return dp[n];
        }
    }


    class Solution1 {
        public int numTrees(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i < n + 1; i++){
                int sum = 0;
                for(int j = 0; j < i; j++){
                    sum += dp[j] * dp[i - j - 1];
                }
                dp[i] = sum;
            }
            return dp[n];
        }
    }

    class Solution2 {
        int[] memo;
        public int numTrees(int n) {
            memo = new int[n + 1];
            memo[0] = 1;
            return dfs(n);
        }
        private int dfs(int n){
            if (memo[n] > 0){
                return memo[n];
            }
            int sum = 0;
            for (int i = 0; i < n; i++){
                sum += dfs(i) * dfs(n - 1 - i);
            }
            memo[n] = sum;
            return sum;
        }
    }
}