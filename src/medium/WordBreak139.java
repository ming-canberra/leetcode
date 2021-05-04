package medium;

import java.util.*;

public class WordBreak139 {
    public static void main(String[] args) {
        WordBreak139 thisClass = new WordBreak139();
        String s = "leetleetleetcode";
        List<String> dict = new ArrayList<String>();
        dict.add("leet");
        dict.add("code");
        thisClass.wordBreak(s, dict);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[]memo = new Boolean[s.length() + 1];

        return wordBreakRecur(s, new HashSet<>(wordDict), 0, memo);
    }

    private boolean wordBreakRecur(String s, Set<String> wordDict, int start, Boolean[]memo) {
        if (memo[start] != null){
            return memo[start];
        }

        if (start == s.length()) {
            return true;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && wordBreakRecur(s, wordDict, end, memo)) {
                memo[start] = true;
                return true;
            }
        }

        memo[start] = false;
        return false;
    }



    class ImplementationBruteForce{


        public boolean wordBreak(String s, List<String> wordDict) {
            // first letter for key, a list of all words starting with the key letter for the value
            HashMap<Character, List<String>> map = new HashMap<Character, List<String>>();
            for (String word : wordDict){
                List<String> wordList = map.getOrDefault(word.charAt(0), new ArrayList<String>());
                wordList.add(word);
                map.put(word.charAt(0), wordList);
            }

            return sContains(s, map, 0, s.length());
        }

        //DFS backtracking
        private boolean sContains(String s, HashMap<Character, List<String>> map, int start, int end){
            String subString = s.substring(start, end);
            char firstChar = subString.charAt(0);
            if (map.containsKey(firstChar)){
                int subLength = subString.length();
                for (String word : map.get(firstChar)){
                    if (subString.startsWith(word)){
                        if (subLength == word.length()){
                            return true;
                        }
                        else{
                            boolean tempResult = sContains(s, map, start + word.length(), end);
                            if (tempResult){
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }
    }
}