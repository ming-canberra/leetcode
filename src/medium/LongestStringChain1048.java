package medium;

import java.util.*;

public class LongestStringChain1048 {

    class Solution {
        public int longestStrChain(String[] words) {
            Arrays.sort(words, (a, b)-> a.length() - b.length() );
            int n = words.length;
            Map<String, Integer> dp = new HashMap<>();// stores the length of each word chain that ends at the word, i.e. as the last successor.
            int result = 1;
            for (String word : words){
                int curMax = 1;
                for (int i = 0; i < word.length(); i++){
                    String pred = word.substring(0, i) + word.substring(i + 1, word.length());
                    if (dp.containsKey(pred)){
                        curMax = Math.max(curMax, dp.get(pred) + 1);
                    }
                }
                dp.put(word, curMax);
                result = Math.max(result, curMax);
            }
            return result;
        }
    }
}