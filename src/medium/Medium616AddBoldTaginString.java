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
    class Solution2 {
        public String addBoldTag(String s, String[] words) {
            TrieNode root = new TrieNode();
            // init the dictionary
            for (String word : words){
                TrieNode cur = root;
                for (char c : word.toCharArray()){
                    if (cur.children[c] == null){
                        cur.children[c] = new TrieNode();
                    }
                    cur = cur.children[c];
                }
                cur.isWord = true;
            }

            boolean[] boldPositions = new boolean[s.length()];

            for (int i = 0; i < s.length(); i++){
                TrieNode cur = root;
                Integer endIndex = null;

                String subString = s.substring(i);
                int tmpCounter = 0;
                for (char c : subString.toCharArray()){
                    if (cur.children[c] == null){
                        break;
                    }
                    tmpCounter++;
                    cur = cur.children[c];
                    if (cur.isWord){
                        endIndex = i + tmpCounter - 1;
                    }
                }
                if (endIndex != null){
                    for (int j = i; j <= endIndex; j++){
                        boldPositions[j] = true;
                    }
                }
            }
            // process boldPositions
            StringBuilder sb = new StringBuilder();
            boolean addOpening = true;

            for (int i = 0; i < s.length(); i++){
                if (addOpening){
                    if (boldPositions[i]){
                        sb.append("<b>");
                        addOpening = false;
                    }
                }
                else{
                    if (!boldPositions[i]){
                        sb.append("</b>");
                        addOpening = true;
                    }
                }

                sb.append(s.charAt(i));

                if (i == s.length() - 1 && !addOpening){
                    sb.append("</b>");
                }
            }
            return sb.toString();
        }

        class TrieNode{
            TrieNode[] children = new TrieNode[256];
            boolean isWord = false;
            TrieNode(){

            }
        }
    }
}