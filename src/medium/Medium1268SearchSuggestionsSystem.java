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
}