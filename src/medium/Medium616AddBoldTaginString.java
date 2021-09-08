package medium;

import java.util.*;

public class Medium616AddBoldTaginString {
    class Solution {
        public String addBoldTag(String s, String[] words) {
            boolean[] bold = new boolean[s.length()];
            for (int i = 0; i < s.length(); i++){
                for (int j = 0; j < words.length; j++){
                    String substring = s.substring(i);
                    if (substring.startsWith(words[j])){
                        for (int k = i; k < i + words[j].length(); k++){
                            bold[k] = true;
                        }
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            boolean toAddOpening = true;
            for (int i = 0; i < s.length(); i++){
                if (toAddOpening && bold[i]){
                    sb.append("<b>");
                    toAddOpening = false;
                }
                sb.append(s.charAt(i));
                if (!toAddOpening && (i == s.length() - 1 || !bold[i + 1] ) ){
                    sb.append("</b>");
                    toAddOpening = true;
                }
            }
            return sb.toString();
        }
    }
}