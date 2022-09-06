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


    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> set = new HashSet<>();
            for (String word : wordDict){
                set.add(word);
            }
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 1; i < dp.length; i++){
                dp[i] = helper(dp, set, i, s);
            }
            return dp[s.length()];
        }
        private boolean helper(boolean[] dp, Set<String> set, int index, String s){
            for (int i = 0; i < index; i++){
                if (dp[i]){
                    if (  set.contains( s.substring(i, index) )  ){
                        return true;
                    }
                }
            }
            return false;
        }
    }

    class Solution2 {
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> set = new HashSet<>();
            for (int i = 0; i < wordDict.size(); i++){
                set.add(wordDict.get(i));
            }
            int n = s.length();
            boolean dp[] = new boolean[n];
            dp[0] = set.contains(s.substring(0, 1));
            for (int i = 1; i < n; i++){
                if (set.contains(s.substring(0, i + 1))){
                    dp[i] = true;
                }
                else{
                    for (int j = 0; j < i; j++){
                        if(dp[j]){
                            if (set.contains(s.substring(j + 1, i + 1))){
                                dp[i] = true;
                                break;
                            }
                        }
                    }
                }
            }
            return dp[n - 1];
        }
    }

    class Solution3 {
        Boolean[] m;
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> set = new HashSet<>(wordDict);
            m = new Boolean[s.length() + 1];
            return dfs(s, s.length(), set);
        }
        boolean dfs(String s, int l, Set<String> set){
            if (l == 0){
                return true;
            }
            if (m[l] != null){
                return m[l];
            }

            for (int i = 0; i < l; i++){
                String right = s.substring(i, l);
                if (set.contains(right)){
                    boolean tmp = dfs(s, i, set);
                    if(tmp){
                        m[l] = true;
                        return true;
                    }
                }
            }
            m[l] = false;
            return false;
        }
    }
}