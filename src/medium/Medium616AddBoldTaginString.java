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

    class Solution1 {
        public String addBoldTag(String s, String[] words) {
            StringBuilder sb = new StringBuilder();
            Arrays.sort(words, (a, b)->a.length() - b.length());
            for (int i = 0; i < s.length(); i++){
                int startIndex = i;
                int endIndex = -1;//
                for (int j = 0; j < words.length; j++){
                    if ( s.substring(i).startsWith(words[j]) ) {
                        endIndex = i + words[j].length();
                    }
                }
                while (endIndex > -1 && i < endIndex){
                    i++;
                    for (int j = 0; j < words.length; j++){
                        if (s.substring(i).startsWith(words[j])){
                            endIndex = Math.max(endIndex, i + words[j].length());
                        }
                    }
                }
                if (endIndex != -1){
                    sb.append("<b>");
                    sb.append(s.substring(startIndex, endIndex));
                    sb.append("</b>");
                    if (i < s.length())
                        sb.append(s.charAt(i));
                }
                else{
                    sb.append(s.charAt(i));
                }
            }
            return sb.toString();
        }
    }
}