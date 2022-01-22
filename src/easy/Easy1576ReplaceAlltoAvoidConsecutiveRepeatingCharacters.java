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

    class Solution1 {
        public String modifyString(String s) {
            char[] charArr = s.toCharArray();
            for (int i = 0; i < s.length(); i++){
                if (charArr[i] == '?'){
                    if (neighborsHaveChar(charArr, i, 'a')){
                        if (neighborsHaveChar(charArr, i, 'b')){
                            charArr[i] = 'c';
                        }
                        else{
                            charArr[i] = 'b';
                        }
                    }
                    else{
                        charArr[i] = 'a';
                    }
                }
            }
            return new String(charArr);
        }
        private boolean neighborsHaveChar(char[] charArr, int idx, char charValue){
            if (idx - 1 >= 0){
                if (charArr[idx - 1] == charValue){
                    return true;
                }
            }
            if (idx + 1 < charArr.length){
                if (charArr[idx + 1] == charValue){
                    return true;
                }
            }
            return false;
        }
    }
}