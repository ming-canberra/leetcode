package medium;

import java.util.*;

public class Medium1105FillingBookcaseShelves {
    class Solution {
        public int minHeightShelves(int[][] books, int shelfWidth) {
            int len = books.length;
            int[] dp = new int[len];
            dp[0] = books[0][1];
            for (int i = 1; i < len; i++){
                int min = dp[i - 1] + books[i][1];
                int curWidth = books[i][0];
                int curHeight = books[i][1];
                for (int j = i - 1; j >= 0; j--){
                    curWidth += books[j][0];
                    if (curWidth > shelfWidth){
                        break;
                    }
                    else{
                        curHeight = Math.max(curHeight, books[j][1]);
                        if (j == 0){
                            min = Math.min(min, curHeight);
                        }
                        else{
                            min = Math.min(min, dp[j - 1] + curHeight);
                        }
                    }
                }
                dp[i] = min;
            }
            return dp[len - 1];
        }
    }
}