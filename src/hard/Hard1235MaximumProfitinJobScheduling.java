package hard;

import java.util.*;

public class Hard1235MaximumProfitinJobScheduling {

    class Solution {
        public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
            int len = profit.length;
            int[][] arr = new int[len][3];
            int[] dp = new int[len];
            for (int i = 0; i < len; i++){
                arr[i] = new int[]{startTime[i], endTime[i], profit[i]};
            }
            Arrays.sort( arr, (a, b)-> a[1] - b[1] ); // endTime ascending sorting
            dp[0] = arr[0][2];
            for (int i = 1; i < len; i++){
                int overlapped = arr[i - 1][1] > arr[i][0] ? dp[i - 1] : 0 ;
                int nonOverlapped = nonOverlappedBS(i - 1, arr, arr[i][0], dp);
                dp[i] = Math.max(nonOverlapped + arr[i][2], overlapped);
            }
            return dp[len - 1];
        }
        // closest ending time less than or equal to start
        private int nonOverlappedBS(int lastPossibleIndex, int[][] arr, int start, int[] dp){
            int lIdx = -1;
            int rIdx = lastPossibleIndex + 1;
            while(lIdx + 1 < rIdx){
                int mIdx = (lIdx + rIdx) / 2;
                if (arr[mIdx][1] <= start){
                    lIdx = mIdx;
                }
                else{
                    rIdx = mIdx;
                }
            }
            return lIdx == -1 ? 0 : dp[lIdx];
        }
    }
}