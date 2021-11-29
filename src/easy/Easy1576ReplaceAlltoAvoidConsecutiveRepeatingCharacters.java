package easy;

public class Easy1576ReplaceAlltoAvoidConsecutiveRepeatingCharacters {
    class Solution {
        public String modifyString(String s) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++){
                char curChar = s.charAt(i);
                if (curChar == '?'){
                    curChar = 'a';
                    if (i >= 1){
                        char prevChar = sb.charAt(i - 1);
                        if (curChar == prevChar){
                            curChar++;
                        }
                    }
                    if (i + 1 < s.length()){
                        char nextChar = s.charAt(i + 1);
                        if (nextChar == curChar){
                            curChar++;
                        }
                    }
                    if (i >= 1){
                        char prevChar = sb.charAt(i - 1);
                        if (curChar == prevChar){
                            curChar++;
                        }
                    }
                }
                sb.append(curChar);
            }
            return sb.toString();
        }
    }
}