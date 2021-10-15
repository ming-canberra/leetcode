package medium;

import java.util.*;

public class Medium1686StoneGameVI {
    class Solution {
        public int stoneGameVI(int[] aliceValues, int[] bobValues) {
            int len = aliceValues.length;
            int[][] sum = new int[len][2];
            int totalScore = 0;
            for (int i = 0; i < len; i++){
                sum[i] = new int[]{aliceValues[i] + bobValues[i], i};
                totalScore += sum[i][0];
            }
            Arrays.sort(sum, (a, b)-> b[0] - a[0]);
            int socreA = 0;
            int socreB = 0;
            for (int i = 0; i < len; i++){
                if (i % 2 == 0){
                    socreA += aliceValues[sum[i][1]];
                }
                else{
                    socreB += bobValues[sum[i][1]];
                }
            }
            return Integer.compare(socreA - socreB, 0);
        }
    }
}