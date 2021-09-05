package medium;

import java.util.*;

public class Medium1065IndexPairsOfAString {
    class Solution {
        public int[][] indexPairs(String text, String[] words) {
            Node trie = new Node();
            for (String w : words){
                Node cur = trie;
                for (int i = 0; i < w.length(); i++){
                    if (cur.children.containsKey(w.charAt(i))){
                        cur = cur.children.get(w.charAt(i));
                    }
                    else{
                        Node tmp = new Node();
                        cur.children.put(w.charAt(i), tmp);
                        cur = tmp;
                    }
                }
                cur.isCompleteWord = true;
            }
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < text.length(); i++){
                int j = i;
                Node cur = trie;
                while( j < text.length() && cur.children.containsKey( text.charAt(j) ) ){
                    cur = cur.children.get(text.charAt(j));
                    if (cur.isCompleteWord){
                        list.add(new int[]{i, j});
                    }
                    j++;
                }
            }
            int[][] result = new int[list.size()][2];
            for (int i = 0; i < list.size(); i++){
                result[i] = list.get(i);
            }
            return result;
        }
        class Node{
            Map<Character, Node> children = new HashMap<>();
            boolean isCompleteWord = false;
        }
    }

    class Solution1 {
        public int[][] indexPairs(String text, String[] words) {
            TrieNode trie = new TrieNode();
            for (String word : words){
                TrieNode cur = trie;
                for (int i = 0; i < word.length(); i++){
                    char c = word.charAt(i);
                    if (cur.children[c - 'a'] == null){
                        cur.children[c - 'a'] = new TrieNode();
                    }
                    cur = cur.children[c - 'a'];
                }
                cur.isCompleteWord = true;
            }
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < text.length(); i++){
                TrieNode cur = trie;
                int j = i;
                while(j < text.length() && cur.children[text.charAt(j) - 'a'] != null){
                    cur = cur.children[text.charAt(j) - 'a'];
                    if (cur.isCompleteWord){
                        list.add(new int[]{i, j});
                    }
                    j++;
                }
            }
            int[][] result = new int[list.size()][2];
            for (int i = 0; i < list.size(); i++){
                result[i] = list.get(i);
            }
            return result;
        }
        class TrieNode{
            TrieNode[] children;
            boolean isCompleteWord;
            public TrieNode(){
                children = new TrieNode[26];
                isCompleteWord = false;
            }
        }
    }
}