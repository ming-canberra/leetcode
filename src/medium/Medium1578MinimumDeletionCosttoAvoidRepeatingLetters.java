package medium;

import java.util.*;

public class Medium1578MinimumDeletionCosttoAvoidRepeatingLetters {
    class Solution {
        public int minCost(String s, int[] cost) {
            int result = 0;
            int left = 0;
            int sumCost = cost[0];
            int maxCost = cost[0];
            for (int i = 1; i < cost.length; i++){
                if ( s.charAt(left) == s.charAt(i) ){
                    sumCost += cost[i];
                    maxCost = Math.max(maxCost, cost[i]);
                    //TODO check the last char
                    if (i == cost.length - 1){
                        if (i - left >= 1){
                            result += (sumCost - maxCost);
                        }
                    }
                }
                else{
                    if (i - 1 - left >= 1){
                        result += (sumCost - maxCost);
                    }
                    sumCost = cost[i];
                    maxCost = cost[i];
                    left = i;
                }
            }
            return result;
        }
    }
}