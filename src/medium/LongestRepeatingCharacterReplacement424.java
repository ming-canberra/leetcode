package medium;

import java.util.*;

public class LongestRepeatingCharacterReplacement424 {
    class Solution {
        public int characterReplacement(String s, int k) {
            int[] counts = new int[26];
            int result = 1;
            int left = 0;
            char[] charArray = s.toCharArray();
            int maxCount = 0;
            for (int i = 0; i < s.length(); i++){
                maxCount = Math.max(maxCount, ++counts[charArray[i] - 'A']);
                while(i - left + 1 - maxCount > k){
                    counts[charArray[left] - 'A']--;
                    left++;
                }
                result = Math.max(result, i - left + 1);
            }
            return result;
        }
    }
}