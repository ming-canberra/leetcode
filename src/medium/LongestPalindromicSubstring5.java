package medium;

public class LongestPalindromicSubstring5 {
    class Solution {
        private int max;
        private String result;
        public String longestPalindrome(String s) {
            max = 1;
            result = s.substring(0, 1);
            for (int i = 1; i < s.length(); i++){
                // handle odd number
                int l = i - 1;
                int r = i + 1;
                helper(l, r, s);
                // handle even number
                l = i - 1;
                r = i;
                helper(l, r, s);
            }
            return result;
        }
        private void helper(int l, int r, String s){
            while (l >= 0 && r <s.length() && s.charAt(l) == s.charAt(r)){
                l--;
                r++;
            }
            l++;
            r--;
            if (l >= 0 && r <s.length() && s.charAt(l) == s.charAt(r)){
                if (r + 1 - l > max){
                    max = r + 1 - l;
                    result = s.substring(l, r + 1);
                }
            }
        }
    }
}