package medium;

import java.util.*;

public class Medium0091DecodeWays {

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

    class Solution1 {
        public int numDecodings(String s) {
            int len = s.length();
            Set<String> set = new HashSet<>();
            for (int i = 1; i <= 26; i++){
                set.add(String.valueOf(i));
            }
            int[]dp = new int[len + 1];
            dp[0] = 1;
            dp[1] = set.contains(s.substring(0, 1)) ? 1 : 0;
            for (int i = 2; i < len + 1; i++){
                int a = dp[i - 2] * (set.contains(s.substring(i - 2, i)) ? 1 : 0);
                int b = dp[i - 1] * (set.contains(s.substring(i - 1, i)) ? 1 : 0);
                dp[i] = a + b;

            }
            return dp[len];
        }
    }

    class Solution2 {

        Map<String, Integer> map = new HashMap<>();

        public int numDecodings(String s) {
            if (map.containsKey(s)) {
                return map.get(s);
            }
            Set<String> valid = new HashSet<>();
            for (int i = 10; i < 27; i++) {
                valid.add(new Integer(i).toString());
            }
            if (s.length() == 1) {
                if (s.equals("0")){
                    return 0;
                }
                return 1;
            }
            else if (s.length() == 0) {
                return 1;
            }
            else {
                int res = numDecodings(s.substring(0, 1)) * numDecodings(s.substring(1, s.length()))
                        + (valid.contains( s.substring(0, 2) ) ? 1 : 0 ) * numDecodings(s.substring(2, s.length()));

                map.put(s, res);

                return res;
            }
        }
    }

    class Solution3 {
        public int numDecodings(String s) {
            int len  = s.length();

            int[] dp = new int[len];

            if (  s.charAt(0) == '0') {
                dp[0] = 0;
            }
            else {
                dp[0] = 1;
            }

            if (len == 1) {
                return dp[0];
            }

            Set<String> valid2DigitsNumber = new HashSet<>();
            for (int i = 10; i < 27; i++) {
                valid2DigitsNumber.add(String.valueOf(i));
            }

            dp[1] = (valid2DigitsNumber.contains(s.substring(0, 2)) ? 1 : 0) + dp[0] * (s.charAt(1) == '0' ? 0 : 1);

            for (int i = 2; i < len; i++) {
                dp[i] = dp[i - 1] * (s.charAt(i) == '0' ? 0 : 1);

                dp[i] += dp[i - 2] * (valid2DigitsNumber.contains(s.substring(i - 1, i + 1)) ? 1 : 0);
            }

            return dp[len - 1];
        }
    }
}