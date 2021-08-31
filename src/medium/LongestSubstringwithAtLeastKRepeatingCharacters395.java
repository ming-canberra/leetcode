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

    /**
     * O(N), tricky sliding window, sliding n times
     */
    class Solution1 {
        private int result = 0;
        public int longestSubstring(String s, int k) {
            Set<Character> charSet = new HashSet<>();
            for (char c : s.toCharArray()){
                charSet.add(c);
            }

            for (int size = 1; size <= charSet.size(); size++){
                Map<Character, Integer> map = new HashMap<>();
                int left = 0;

                for (int i = 0; i < s.length(); i++){
                    Character c = s.charAt(i);
                    if (map.containsKey(c)){
                        map.put(c, map.get(c) + 1);
                    }
                    else{
                        if (map.size() == size){
                            //count it to see if it meets the requirement
                            countResult(map, k, left, i - 1);

                            // move left and remove what is at left, until map size reduces by 1
                            while(map.get(s.charAt(left)) != 1  ){
                                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                                left++;
                            }
                            map.remove(s.charAt(left));
                            left++;
                        }
                        map.put(c, 1);
                    }
                    if (i == s.length() - 1){
                        countResult(map, k, left, i);
                    }
                }
            }
            return result;
        }
        private void countResult(Map<Character, Integer> map, int k, int left, int i){
            //count it to see if it meets the requirement
            boolean eachGreaterThanK = true;
            for (Integer count : map.values()){
                if (count < k){
                    eachGreaterThanK = false;
                    break;
                }
            }
            if (eachGreaterThanK){
                result = Math.max(result, i - left + 1);
            }
        }
    }
}