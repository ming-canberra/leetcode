package medium;

import java.util.*;

public class Medium1268SearchSuggestionsSystem {

    class Solution {
        public List<List<String>> suggestedProducts(String[] products, String searchWord) {
            TrieNode trie = new TrieNode("");
            // init trie
            for (String word : products){
                TrieNode curTrie = trie;
                for (int i = 0; i < word.length(); i++){
                    char cc = word.charAt(i);
                    if (curTrie.children[cc - 'a'] == null){
                        curTrie.children[cc - 'a'] = new TrieNode(curTrie.word + cc);
                    }
                    curTrie = curTrie.children[cc - 'a'];
                }
                curTrie.isWord = true;
            }
            List<List<String>> result = new ArrayList<>();
            for (int i = 0; i < searchWord.length(); i++){
                String word = searchWord.substring(0, i + 1);
                result.add(search(trie, word));
            }
            return result;
        }
        private List<String> search(TrieNode trie, String word){
            TrieNode cur = trie;
            List<String> result = new ArrayList<>();
            for (int i = 0; i < word.length(); i++){
                char cc = word.charAt(i);
                cur = cur.children[cc - 'a'];
                if (cur == null){
                    return result;
                }
            }
            //get the top 3 words if there are any
            retrieveTop3(cur, result);
            return result;
        }
        private void retrieveTop3 (TrieNode trie, List<String> list){
            if (trie == null || list.size() == 3){
                return;
            }
            if (trie.isWord){
                list.add(trie.word);
            }
            for (TrieNode node : trie.children){
                retrieveTop3(node, list);
            }
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
        Trie allProducts = new Trie("");

        public List<List<String>> suggestedProducts(String[] products, String searchWord) {

            for (String prd : products) {

                addToTrie(prd);

            }

            List<List<String>> res = new ArrayList<>();

            for (int i = 1; i <= searchWord.length(); i++) {
                String curString = searchWord.substring(0, i);

                res.add(getFirst3Words(curString));

            }

            return res;
        }

        private List<String> getFirst3Words(String prefix) {
            List<String> res = new ArrayList<>();

            Trie cur = allProducts;


            for (char charV : prefix.toCharArray()) {
                if (cur.children[charV - 'a'] == null) {
                    return res;
                }
                cur = cur.children[charV - 'a'];
            }


            int counter = 3;
            Stack<Trie> stack = new Stack<>();
            stack.add(cur);
            while(counter > 0 && !stack.isEmpty()) {
                Trie top = stack.pop();
                if (top.isWord) {
                    counter--;
                    res.add(top.word);
                }
                for (int i = 25; i>= 0; i--) {
                    Trie child = top.children[i];
                    if (child != null) {
                        stack.push(child);
                    }
                }
            }

            return res;
        }



        private void addToTrie(String product) {
            Trie cur = allProducts;

            for (char charV : product.toCharArray()) {
                if (cur.children[charV - 'a'] == null) {
                    cur.children[charV - 'a'] = new Trie(cur.word + charV);
                }
                cur = cur.children[charV - 'a'];
            }
            cur.isWord = true;


        }

        private class Trie{
            boolean isWord = false;
            String word = "";
            Trie[] children = new Trie[26];

            Trie(String input) {
                word = input;
            }

        }

    }
}