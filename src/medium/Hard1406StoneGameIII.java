package medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Hard1406StoneGameIII {
    class Solution {
        public String stoneGameIII(int[] stoneValue) {
            int score = getOptimal(stoneValue, 0, new Integer[stoneValue.length]);
            if (score > 0){
                return "Alice";
            }
            else if (score < 0){
                return "Bob";
            }
            else{
                return "Tie";
            }
        }
        private int getOptimal(int[] stoneValue, int start, Integer[] memo){
            int len = stoneValue.length;
            if (start >= len){
                return 0;
            }
            int result;
            if (memo[start] != null){
                result = memo[start];
                return result;
            }
            else{
                result = stoneValue[start] - getOptimal(stoneValue, start + 1, memo);
            }
            if (start + 1 < len){
                int op2 = stoneValue[start] + stoneValue[start + 1] - getOptimal(stoneValue, start + 2, memo);
                result = Math.max(result, op2);
            }
            if (start + 2 < len){
                int op3 = stoneValue[start] + stoneValue[start + 1] + stoneValue[start + 2] - getOptimal(stoneValue, start + 3, memo);
                result = Math.max(result, op3);
            }
            memo[start] = result;
            return result;
        }
    }
}