package medium;

import java.util.*;

public class Medium0208ImplementTrie {
    class Trie {
        Trie[] children;
        boolean isWord;
        /** Initialize your data structure here. */
        public Trie() {
            children = new Trie[26];
            isWord = false;
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Trie cur = this;
            for (int i = 0; i < word.length(); i++){
                if (cur.children[word.charAt(i) - 'a'] == null){
                    cur.children[word.charAt(i) - 'a'] = new Trie();
                }
                cur = cur.children[word.charAt(i) - 'a'];
            }
            cur.isWord = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Trie cur = this;
            for (int i = 0; i < word.length(); i++){
                if (cur.children[word.charAt(i) - 'a'] == null){
                    return false;
                }
                cur = cur.children[word.charAt(i) - 'a'];
            }
            return cur.isWord;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Trie cur = this;
            for (int i = 0; i < prefix.length(); i++){
                if (cur.children[prefix.charAt(i) - 'a'] == null){
                    return false;
                }
                cur = cur.children[prefix.charAt(i) - 'a'];
            }
            return true;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}