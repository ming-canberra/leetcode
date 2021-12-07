package medium;

import java.util.*;

public class Medium0424LongestRepeatingCharacterReplacement {
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

    class Solution1 {
        public int characterReplacement(String s, int k) {
            int[] charCount = new int[26];
            int left = 0;
            int maxCharCount = 1;
            int result = 1;
            for (int i = 0; i < s.length(); i++){
                char cc = s.charAt(i);
                maxCharCount = Math.max(maxCharCount, ++charCount[cc - 'A']);
                if (i - left + 1 - maxCharCount > k){
                    charCount[s.charAt(left) - 'A']--;
                    left++;
                }
                result = Math.max(result, i - left + 1);
            }
            return result;
        }
    }
}