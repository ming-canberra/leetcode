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

    class Solution2 {
        public int[][] indexPairs(String text, String[] words) {
            List<int[]> resultList = new ArrayList<>();
            for (int i = 0; i < text.length(); i++){
                String subText = text.substring(i);
                for (String wd : words){
                    if (subText.startsWith(wd)){
                        resultList.add(new int[]{i, i + wd.length() - 1});
                    }
                }
            }
            Collections.sort(resultList, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            int[][] result = new int[resultList.size()][2];
            for (int i = 0; i < result.length; i++){
                result[i][0] = resultList.get(i)[0];
                result[i][1] = resultList.get(i)[1];
            }
            return result;
        }
    }

    class Solution3 {
        public int[][] indexPairs(String text, String[] words) {
            List<Pair> result = new ArrayList<>();
            for (int i = 0; i < text.length(); i++){
                String subString = text.substring(i);
                for (int j = 0; j < words.length; j++){
                    if ( subString.startsWith(words[j]) ){
                        result.add(new Pair(i, i + words[j].length() - 1));
                    }
                }
            }
            Collections.sort(result, (a, b)-> a.x == b.x ? a.y - b.y : a.x - b.x );
            int[][] tmp = new int[result.size()][2];
            for (int i = 0; i < tmp.length; i++){
                tmp[i][0] = result.get(i).x;
                tmp[i][1] = result.get(i).y;
            }
            return tmp;
        }
        class Pair{
            int x;
            int y;
            Pair(int xInput, int yInput){
                x = xInput;
                y = yInput;
            }
        }
    }
}