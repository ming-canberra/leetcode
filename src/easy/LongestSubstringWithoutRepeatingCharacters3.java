package easy;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters3 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        int max = 0;
        char[] charArray = s.toCharArray();
        int mapStartingIndex = 0;
        for (int i =0; i < charArray.length; i++){

            if (!map.containsKey(charArray[i])){
                if (map.size() == 0){
                    mapStartingIndex = i;
                }
                map.put(charArray[i] , i);
            }
            else{
                int matchedCharIndex = map.get(charArray[i]);
                max = Math.max(max, i - mapStartingIndex);
                int newMapStartingIndex = 1+ map.get(charArray[i]);
                for (int j = mapStartingIndex; j <newMapStartingIndex; j++){
                    map.remove(charArray[j]);
                }
                mapStartingIndex = newMapStartingIndex;

                map.put(charArray[i] , i);
            }
        }
        // get the max out of max and map;
        max = Math.max(max, map.size());

        return max;
    }

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s.length() < 2){
                return s.length();
            }
            int l = 0;
            Set<Character> set = new HashSet<>();//current longest Substring
            int result = 1;
            for (int r = 0; r < s.length(); r++){
                char curChar = s.charAt(r);

                if (set.contains(curChar)){
                    while(s.charAt(l) != curChar){
                        set.remove(s.charAt(l));
                        l++;
                    }
                    l++;
                }
                else{
                    set.add(curChar);
                    result = Math.max(result, set.size());
                }
            }
            return result;
        }
    }
}