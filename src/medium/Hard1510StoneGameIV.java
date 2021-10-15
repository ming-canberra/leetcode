package medium;
import java.util.*;

public class Hard1510StoneGameIV {
    class Solution {
        public boolean winnerSquareGame(int n) {
            boolean[] dp = new boolean[n + 1];
            dp[1] = true;
            int curSqr = 1;
            for (int i = 2; i < n + 1; i++){
                if ( (curSqr + 1) * (curSqr + 1) == i ){
                    dp[i] = true;
                    curSqr++;
                    continue;
                }
                boolean tmpResult = false;
                for (int j = curSqr; j >= 1; j--){
                    if (!dp[i - j * j]){
                        tmpResult = true;
                        break;
                    }
                }
                dp[i] = tmpResult;
            }
            return dp[n];
        }
    }
}