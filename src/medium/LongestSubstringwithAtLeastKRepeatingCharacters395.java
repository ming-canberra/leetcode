package medium;

import java.util.*;

public class LongestSubstringwithAtLeastKRepeatingCharacters395 {
    class Solution {
        public int longestSubstring(String s, int k) {
            int result = 0;
            char[] array = s.toCharArray();
            int length = array.length;
            for (int i = 0; i < length; i++){
                Map<Character, Integer> map = new HashMap<>();
                Set<Character> set = new HashSet<>();// store the number of Chars that are less than k
                for (int j = i; j < length; j++){
                    Character curChar = array[j];
                    map.put(curChar, map.getOrDefault(curChar, 0) + 1);
                    if (map.get(curChar) < k){
                        set.add(curChar);
                    }
                    else{
                        set.remove(curChar);
                    }
                    if (set.size() == 0){
                        result = Math.max(result, j - i + 1);
                    }
                }
            }
            return result;
        }
    }
}