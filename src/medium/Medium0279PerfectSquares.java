package medium;

import java.util.ArrayList;
import java.util.List;

public class Medium0279PerfectSquares {
    public int numSquares(int n) {
        int currentSquareRoot = 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++){
            if (currentSquareRoot * currentSquareRoot ==i){
                dp[i] = 1;
                currentSquareRoot++;
            }
            else{
                // loop through squareRootList
                dp[i] = Integer.MAX_VALUE;
                for (int j = 1; j< currentSquareRoot; j++){
                    dp[i] =Math.min(dp[i], 1 + dp[i - j * j]);
                }
            }
        }

        return dp[n];
    }

    class Solution {
        public int numSquares(int n) {
            List<Integer> candidates = new ArrayList<>();

            for (int i = 1; i * i <= n; i++){
                candidates.add(i * i);
            }

            int[] dp = new int[n + 1];
            dp[1] = 1;
            for (int i = 2; i < n + 1; i++){
                dp[i] = Integer.MAX_VALUE;
                for (int j = 0; j < candidates.size(); j++){
                    if(i == candidates.get(j)){
                        dp[i] = 1;
                        break;
                    }
                    else if (i < candidates.get(j)){
                        break;
                    }
                    else{
                        dp[i] = Math.min(dp[i], 1 + dp[i - candidates.get(j)]);
                    }
                }
            }

            return dp[n];
        }
    }

    class Solution1 {
        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i < n + 1; i++){
                int min = Integer.MAX_VALUE;
                for (int j = 1; i >= j * j; j++){
                    min = Math.min(min, 1 + dp[i - j * j]);
                }
                dp[i] = min;
            }
            return dp[n];
        }
    }

    class Solution2 {
        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            int sRoot = 1;
            dp[1] = 1;
            for (int i = 2; i < n + 1; i++){
                if( ( (sRoot + 1) * (sRoot + 1) ) == i ){
                    dp[i] = 1;
                    sRoot++;
                }
                else{
                    int min = Integer.MAX_VALUE;
                    for (int j = 1; j <= sRoot; j++){
                        min = Math.min(min, 1 + dp[i - j * j]);
                    }
                    dp[i] = min;
                }
            }
            return dp[n];
        }
    }
}