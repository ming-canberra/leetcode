package medium;

import java.util.*;

public class DecodeWays91 {

    class Solution {
        public int numDecodings(String s) {
            if (s.startsWith("0")){
                return 0;
            }
            int n = s.length();
            int[] dp = new int[n];
            dp[0] = 1;
            String[] codes = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                    "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                    "21", "22", "23", "24", "25", "26" };
            Set<String> set = new HashSet<>();

            for(String item : codes){
                set.add(item);
            }

            for (int i = 1; i < n; i++){
                int minus1Count = 0;
                if (set.contains(s.substring(i, i + 1) ) ){
                    minus1Count = dp[i - 1];
                }
                int minus2Count = 0;
                if (set.contains(s.substring(i - 1, i + 1) ) ){
                    if(i == 1){
                        minus2Count = 1;
                    }
                    else{
                        minus2Count = dp[i - 2];
                    }
                }
                dp[i] = minus1Count + minus2Count;
            }
            return dp[n - 1];
        }
    }
}