package medium;

public class MaximumPointsYouCanObtainfromCards1423 {
    class Solution {
        public int maxScore(int[] cardPoints, int k) {
            int n = cardPoints.length;
            int[] lSum = new int[k + 1];
            int[] rSum = new int[k + 1];
            lSum[0] = 0;
            for (int i = 0; i < k; i++){
                lSum[i + 1] = lSum[i] + cardPoints[i];
            }
            rSum[0] = 0;
            for (int i = n - 1; i >= n - k; i--){
                rSum[n - i] = rSum[n - 1 - i] + cardPoints[i];
            }
            int result = 0;
            for (int i = 0; i < k + 1; i++){
                result = Math.max(result, lSum[i] + rSum[k - i]);
            }
            return result;
        }
    }
}