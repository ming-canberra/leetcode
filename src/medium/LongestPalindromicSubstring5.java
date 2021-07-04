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

    class Solution2 {
        public String longestPalindrome(String s) {
            int n = s.length();
            boolean dp[][] = new boolean[n][n]; //s.substring(i, j + 1) is palindrome
            int maxLength = 1;
            int i = 0;
            int j = 0;
            for (int r = n - 1; r >= 0; r--){
                for (int c = r; c < n; c++){
                    if (r == c){
                        dp[r][c] = true;
                    }
                    else{
                        if (s.charAt(r) == s.charAt(c)){
                            if (r + 1 == c){
                                dp[r][c] = true;
                                if (2 > maxLength ){
                                    maxLength = 2;
                                    i = r;
                                    j = c;
                                }
                            }
                            else{
                                if (dp[r + 1][c - 1]){
                                    dp[r][c] = true;
                                    if (c + 1 - r > maxLength ){
                                        maxLength = c + 1 - r;
                                        i = r;
                                        j = c;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return s.substring(i, j + 1);
        }
    }
}