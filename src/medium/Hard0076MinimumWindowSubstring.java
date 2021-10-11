package medium;

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
}