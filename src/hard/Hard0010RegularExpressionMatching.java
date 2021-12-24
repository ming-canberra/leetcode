package hard;

import java.util.*;

public class Hard0010RegularExpressionMatching {
    class Solution {
        public boolean isMatch(String text, String pattern) {
            return isMatch(text, pattern, 0, 0);
        }
        private boolean isMatch(String s, String p, int i, int j){
            int lenS = s.length();
            int lenP = p.length();

            if (j == lenP){
                return i == lenS;
            }

            char charP = p.charAt(j);
            if(j + 1 < lenP && p.charAt(j + 1) == '*'){
                if ( isMatch(s, p, i, j + 2) ){
                    return true;
                }
                if (i < lenS && (s.charAt(i) == charP || charP == '.')){
                    if(isMatch(s, p, i + 1, j)) {
                        return true;
                    }
                }
            }
            else{
                if (i < lenS && (s.charAt(i) == charP || charP == '.')){
                    return isMatch(s, p, i + 1, j + 1);
                }
            }
            return false;
        }
    }
}