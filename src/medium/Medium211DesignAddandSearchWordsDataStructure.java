package medium;

public class Medium211DesignAddandSearchWordsDataStructure {
    class WordDictionary {

        WordDictionary[] children;
        boolean isWord;
        /** Initialize your data structure here. */
        public WordDictionary() {
            children = new WordDictionary[26];
            isWord = false;
        }

        public void addWord(String word) {
            WordDictionary cur = this;
            for (int i = 0; i < word.length(); i++){
                if (cur.children[word.charAt(i) - 'a'] == null){
                    cur.children[word.charAt(i) - 'a'] = new WordDictionary();
                }
                cur = cur.children[word.charAt(i) - 'a'];
            }
            cur.isWord = true;
        }

        public boolean search(String word) {
            return matchWord(this, word);
        }

        private boolean matchWord(WordDictionary dict, String word){
            if (dict == null){
                return false;
            }
            if (word.length() == 0){
                return dict.isWord;
            }
            WordDictionary cur = dict;
            for (int i = 0; i < word.length(); i++){
                char curChar = word.charAt(i);
                if (curChar == '.'){
                    for (int j = 0; j < 26; j++){
                        boolean tmp = matchWord(cur.children[j], word.substring(i + 1, word.length() ) );
                        if (tmp){
                            return true;
                        }
                    }
                    return false;
                }
                else{
                    cur = cur.children[curChar - 'a'];
                    if (cur == null){
                        return false;
                    }
                }
            }
            return cur.isWord;
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
}