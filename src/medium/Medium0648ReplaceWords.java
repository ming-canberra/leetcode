package medium;

import java.util.*;

public class Medium0648ReplaceWords {
    class Solution {
        public String replaceWords(List<String> dictionary, String sentence) {
            TrieNode trie = new TrieNode("");
            for (int i = 0; i < dictionary.size(); i++){
                TrieNode cur = trie;
                for (int j = 0; j < dictionary.get(i).length(); j++){
                    char cc = dictionary.get(i).charAt(j);
                    if (cur.children[cc - 'a'] == null){
                        cur.children[cc - 'a'] = new TrieNode(cur.word + cc);
                    }
                    cur = cur.children[cc - 'a'];
                }
                cur.isWord = true;
            }
            StringBuilder sb = new StringBuilder();
            String[] splits = sentence.split(" ");
            for (int i = 0; i < splits.length; i++){
                String curString = splits[i];
                TrieNode cur = trie;
                for (int j = 0; j < curString.length(); j++){
                    char cc = curString.charAt(j);
                    cur = cur.children[cc - 'a'];
                    if (cur == null || cur.isWord){
                        break;
                    }
                }
                String succ;
                if (cur == null){
                    succ = curString;
                }
                else if (cur.isWord){
                    succ = cur.word;
                }
                else{
                    succ = curString;
                }
                if (i != splits.length - 1){
                    sb.append(succ + " ");
                }
                else{
                    sb.append(succ);
                }
            }
            return sb.toString();
        }
        class TrieNode{
            TrieNode[] children = new TrieNode[26];
            boolean isWord = false;
            String word;
            public TrieNode(String input){
                word = input;
            }
        }
    }

    class Solution1 {
        public String replaceWords(List<String> dictionary, String sentence) {
            TrieNode root = new TrieNode("");
            for (String word : dictionary){
                TrieNode cur = root;
                for (char c : word.toCharArray()){
                    if (cur.children[c - 'a'] == null){
                        cur.children[c - 'a'] = new TrieNode(cur.word + c);
                    }
                    cur = cur.children[c - 'a'];
                }
                cur.isWord = true;
            }
            String[] splits = sentence.split(" ");
            StringBuilder sb = new StringBuilder();
            for (String word : splits){
                TrieNode cur = root;
                for (char c : word.toCharArray()){
                    if (cur.children[c - 'a'] == null){
                        cur = null;
                        break;
                    }
                    cur = cur.children[c - 'a'];
                    //found the shortest root;
                    if (cur.isWord){
                        break;
                    }
                }
                if (cur != null && cur.isWord){
                    sb.append(cur.word + " ");
                }
                else{
                    sb.append(word + " ");
                }
            }
            String result = sb.toString();
            return result.substring(0, result.length() - 1);
        }
        class TrieNode{
            TrieNode[] children = new TrieNode[26];
            boolean isWord = false;
            String word = "";
            public TrieNode(String w){
                word = w;
            }
        }
    }
}