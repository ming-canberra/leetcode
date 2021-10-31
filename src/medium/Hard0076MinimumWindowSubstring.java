package medium;

import java.util.*;

public class Hard0076MinimumWindowSubstring {
    class Solution {
        public String minWindow(String s, String t) {
            int[] map = new int[128];
            for (char c : t.toCharArray()){
                map[c]++;
            }
            int counter = t.length();
            int left = 0;
            int right = 0;
            int resultLength = Integer.MAX_VALUE;
            int resultLeft = 0;
            int resultRight = 0;
            while(right < s.length()){
                if (map[s.charAt(right)] > 0){
                    counter--;
                }
                map[s.charAt(right)]--;
                right++;
                while(counter == 0 && left < s.length()){
                    if (right - left < resultLength){
                        resultRight = right;
                        resultLeft = left;
                        resultLength = resultRight - resultLeft;
                    }
                    map[s.charAt(left)]++;
                    if (map[s.charAt(left)] > 0){
                        counter = 1;
                    }
                    left++;
                }
            }
            return resultRight == 0 ? "" : s.substring(resultLeft, resultRight);
        }
    }

    class Solution1 {
        public String minWindow(String s, String t) {
            int m = s.length();
            int n = t.length();
            if (m < n){
                return "";
            }
            Map<Character, Integer> tMap = new HashMap<>();  // char as key, count as value
            for (char c : t.toCharArray()){
                int cCount = tMap.getOrDefault(c, 0) + 1;
                tMap.put(c, cCount);
            }
            int charCount = tMap.size();
            String result = "";
            int left = 0;
            for (int right = 0; right < s.length(); right++){
                char curChar = s.charAt(right);
                if (tMap.containsKey(curChar)){
                    if (tMap.get(curChar) == 1){
                        charCount--;
                        if (charCount == 0){
                            // init result
                            result = s.substring(left, right + 1);
                        }
                    }
                    tMap.put(curChar, tMap.get(curChar) - 1);
                    if (charCount == 0){
                        // move left until current left count = 0
                        while(!tMap.containsKey(s.charAt(left)) || tMap.get( s.charAt(left) ) != 0){
                            if ( tMap.containsKey(s.charAt(left)) ){
                                tMap.put(s.charAt(left),  tMap.get(s.charAt(left)) + 1 );
                            }
                            left++;
                        }
                        String newSub = s.substring(left, right + 1);
                        if (newSub.length() < result.length()){
                            result = newSub;
                        }
                    }
                }
            }
            return result;
        }
    }
}