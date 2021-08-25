package medium;

import java.util.*;

public class LongestSubstringWithAtMostKDistinctCharacters340 {
    class Solution {
        public int lengthOfLongestSubstringKDistinct(String s, int k) {
            if (k == 0){
                return 0;
            }
            int result = 0;
            int left = 0;
            Map<Character, Integer> map = new HashMap<>();// char to end index
            for (int i = 0; i < s.length(); i++){
                Character curChar = s.charAt(i);
                if (map.containsKey(curChar) || map.size() < k){
                    map.put(curChar, i);
                    result = Math.max(result, i - left + 1);
                }
                else{
                    //increment left and find the index of first char that is the last occurance of this char
                    while(left != map.get(s.charAt(left)) ){
                        left++;
                    }
                    map.remove(s.charAt(left));
                    left++;
                    map.put(curChar, i);
                }
            }
            return result;
        }
    }
}