package medium;

import java.util.*;

public class Medium0186ReverseWordsinaStringII {
    class Solution {
        public void reverseWords(char[] s) {
            reverse(s, 0, s.length - 1);
            int left = 0;
            for (int i = 0; i < s.length; i++){
                if (s[i] == ' '){
                    reverse(s, left, i - 1);
                    left = i + 1;
                }
                else if (i == s.length - 1){
                    reverse(s, left, i);
                }
            }
        }
        private void reverse(char[] s, int start, int end){
            while(start < end){
                char tmp = s[start];
                s[start] = s[end];
                s[end] = tmp;
                start++;
                end--;
            }
        }
    }
}