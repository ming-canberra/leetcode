package medium;

public class Medium1804ImplementTrieIIPrefixTree {
    class Trie {

        TrieNode trie;
        public Trie() {
            trie = new TrieNode();
        }

        public void insert(String word) {
            TrieNode cur = trie;
            for (int i = 0; i < word.length(); i++){
                char cc = word.charAt(i);
                if (cur.children[cc - 'a'] == null){
                    cur.children[cc - 'a'] = new TrieNode();
                }
                cur = cur.children[cc - 'a'];
            }
            cur.isWord = true;
            cur.count = cur.count + 1;
        }

        public int countWordsEqualTo(String word) {
            TrieNode cur = trie;
            for (int i = 0; i < word.length(); i++){
                char cc = word.charAt(i);
                if (cur.children[cc - 'a'] == null){
                    return 0;
                }
                cur = cur.children[cc - 'a'];
            }
            if (cur.isWord){
                return cur.count;
            }
            else{
                return 0;
            }
        }

        public int countWordsStartingWith(String prefix) {
            TrieNode cur = trie;
            for (int i = 0; i < prefix.length(); i++){
                char cc = prefix.charAt(i);
                if (cur.children[cc - 'a'] == null){
                    return 0;
                }
                cur = cur.children[cc - 'a'];
            }
            // dfs cur now
            return dfsTrieNode(cur);
        }

        private int dfsTrieNode(TrieNode cur){
            if (cur == null){
                return 0;
            }
            int sum = 0;
            if (cur.isWord){
                sum += cur.count;
            }
            for (int i = 0; i < 26; i++){
                TrieNode child = cur.children[i];
                sum += dfsTrieNode(child);
            }
            return sum;
        }

        public void erase(String word) {
            TrieNode cur = trie;
            for (int i = 0; i < word.length(); i++){
                char cc = word.charAt(i);
                cur = cur.children[cc - 'a'];
            }
            if (cur.count == 1)
            {
                cur.isWord = false;
                cur.count = 0;
            }
            else{
                cur.count = cur.count - 1;
            }
        }
        class TrieNode{
            TrieNode[] children = new TrieNode[26];
            boolean isWord = false;
            int count = 0;
            public TrieNode(){
            }
        }
    }

    class Trie2 {

        TrieNode trie;
        public Trie2() {
            trie = new TrieNode();
        }

        public void insert(String word) {
            TrieNode cur = trie;
            for (int i = 0; i < word.length(); i++){
                char cc = word.charAt(i);
                if (cur.children[cc - 'a'] == null){
                    cur.children[cc - 'a'] = new TrieNode();
                }
                cur = cur.children[cc - 'a'];
                cur.countPre++;
            }
            cur.isWord = true;
            cur.count = cur.count + 1;
        }

        public int countWordsEqualTo(String word) {
            TrieNode cur = trie;
            for (int i = 0; i < word.length(); i++){
                char cc = word.charAt(i);
                if (cur.children[cc - 'a'] == null){
                    return 0;
                }
                cur = cur.children[cc - 'a'];
            }
            if (cur.isWord){
                return cur.count;
            }
            else{
                return 0;
            }
        }

        public int countWordsStartingWith(String prefix) {
            TrieNode cur = trie;
            for (int i = 0; i < prefix.length(); i++){
                char cc = prefix.charAt(i);
                if (cur.children[cc - 'a'] == null){
                    return 0;
                }
                cur = cur.children[cc - 'a'];
            }
            // dfs cur now
            return cur.countPre;
        }

        public void erase(String word) {
            TrieNode cur = trie;
            for (int i = 0; i < word.length(); i++){
                char cc = word.charAt(i);
                cur = cur.children[cc - 'a'];
                cur.countPre--;
            }
            if (cur.count == 1)
            {
                cur.isWord = false;
                cur.count = 0;
            }
            else{
                cur.count = cur.count - 1;
            }
        }
        class TrieNode{
            TrieNode[] children = new TrieNode[26];
            boolean isWord = false;
            int count = 0;
            int countPre = 0;
            public TrieNode(){
            }
        }
    }
    class Trie3 {
        TrieNode root = new TrieNode();
        public Trie3() {
        }
        public void insert(String word) {
            TrieNode curTrie = root;
            for (char c : word.toCharArray()){
                if (curTrie.children[c - 'a'] == null){
                    curTrie.children[c - 'a'] = new TrieNode();
                }
                curTrie = curTrie.children[c - 'a'];
            }
            curTrie.count++;
        }
        public int countWordsEqualTo(String word) {
            TrieNode curTrie = root;
            for (char c : word.toCharArray()){
                if (curTrie.children[c - 'a'] == null){
                    return 0;
                }
                curTrie = curTrie.children[c - 'a'];
            }
            return curTrie.count;
        }
        public int countWordsStartingWith(String prefix) {
            TrieNode curTrie = root;
            for (char c : prefix.toCharArray()){
                if (curTrie.children[c - 'a'] == null){
                    return 0;
                }
                curTrie = curTrie.children[c - 'a'];
            }
            return traverse(curTrie);
        }
        private int traverse(TrieNode node){
            if (node == null){
                return 0;
            }
            int result = node.count;
            for (TrieNode child : node.children){
                result += traverse(child);
            }
            return result;
        }
        public void erase(String word) {
            TrieNode curTrie = root;
            for (char c : word.toCharArray()){
                curTrie = curTrie.children[c - 'a'];
            }
            curTrie.count--;
        }
        class TrieNode{
            TrieNode[] children = new TrieNode[26];
            int count = 0;
            public TrieNode(){
            }
        }
    }

}