package medium;

import java.util.*;

public class Medium1626BestTeamWithNoConflicts {
    class Solution {
        public int bestTeamScore(int[] scores, int[] ages) {
            int len = ages.length;
            int[][] players = new int[len][2];
            for (int i = 0; i < len; i++){
                players[i] = new int[]{scores[i], ages[i]};
            }
            Arrays.sort(players, ( (a, b) -> b[1] - a[1] == 0 ? b[0] - a[0] : b[1] - a[1] ) );
            int[] dp = new int[len];
            int result = players[0][0];
            for (int i = 0; i < len; i++){
                int max = players[i][0];
                for (int j = 0; j <= i - 1; j++){
                    //conflicts
                    if (players[i][1] < players[j][1] && players[i][0] > players[j][0]){

                    }
                    else{
                        max = Math.max(max, dp[j] + players[i][0]);
                    }
                }
                dp[i] = max;
                result = Math.max(result, max);
            }
            return result;
        }
    }

    class Solution1 {
        public int bestTeamScore(int[] scores, int[] ages) {
            int len = ages.length;
            int[][] arr = new int[len][2];
            for (int i = 0; i < len; i++){
                arr[i] = new int[]{scores[i], ages[i]};
            }
            Arrays.sort(arr, (a, b)-> a[1] == b[1] ? b[0] - a[0] :  b[1] - a[1]);
            int[]dp = new int[len];
            int result = arr[0][0];
            for (int i = 0; i < len; i++){
                dp[i] = arr[i][0];
                for (int j = 0; j < i; j++){
                    if (arr[i][0] <= arr[j][0]){
                        dp[i] = Math.max(dp[i], dp[j] + arr[i][0]);
                    }
                }
                result = Math.max(result, dp[i]);
            }
            return result;
        }
    }
}