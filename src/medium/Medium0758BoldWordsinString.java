package medium;

import java.util.*;

public class Medium0758BoldWordsinString {
    class Solution {
        public String boldWords(String[] words, String s) {
            int len = s.length();
            boolean[] bold = new boolean[len];
            for (int i = 0; i < len; i++){
                String substring = s.substring(i);
                for (int j = 0; j < words.length; j++){
                    if (substring.startsWith(words[j])){
                        for (int k = i; k < i + words[j].length(); k++){
                            bold[k] = true;
                        }
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            boolean toAddOpening = true;
            for (int i = 0; i < len; i++){
                if (toAddOpening){
                    if (bold[i]){
                        sb.append("<b>");
                        toAddOpening = false;
                    }
                    sb.append(s.charAt(i));
                }
                else{
                    if (bold[i]){
                        sb.append(s.charAt(i));
                    }
                    else{
                        sb.append("</b>");
                        toAddOpening = true;
                        sb.append(s.charAt(i));
                    }
                }
                if (!toAddOpening && i == len - 1){
                    sb.append("</b>");
                }
            }
            return sb.toString();
        }
    }
}