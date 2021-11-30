package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Medium1297MaximumNumberofOccurrencesofaSubstring {
    class Solution {
        public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
            Map<String, Integer> stringCount = new HashMap<>();

            int left = 0;

            Map<Character, Integer> charCount = new HashMap<>();

            int result = 0;

            for (int right = 0; right < s.length(); right++){
                //put right char into charCount
                char curRightChar = s.charAt(right);
                int newCount = charCount.getOrDefault(curRightChar, 0) + 1;
                charCount.put(curRightChar, newCount);
                while (charCount.size() > maxLetters)
                {
                    // move left to reduce charCount
                    int curCharCount = charCount.get(s.charAt(left));
                    if (curCharCount == 1){
                        charCount.remove(s.charAt(left));
                    }
                    else{
                        charCount.put(s.charAt(left), curCharCount - 1);
                    }

                    left++;
                }

                if (right - left + 1 >= minSize){
                    String curSubString = s.substring(left, right + 1);
                    int tmpCount = stringCount.getOrDefault(curSubString, 0) + 1;
                    stringCount.put(curSubString, tmpCount);
                    result = Math.max(result, tmpCount);

                    while (right - left + 1 >= minSize)
                    {
                        // move left to reduce charCount
                        int curCharCount = charCount.get(s.charAt(left));
                        if (curCharCount == 1){
                            charCount.remove(s.charAt(left));
                        }
                        else{
                            charCount.put(s.charAt(left), curCharCount - 1);
                        }

                        left++;
                    }

                }
            }

            return result;
        }
    }

    class Solution1 {
        public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
            Map<String, Integer> subOccurences = new HashMap<>();
            int left = 0;
            Map<Character, Integer> slidingWindow = new HashMap<>();
            int result = 0;
            for (int i = 0; i < s.length(); i++){
                char curChar = s.charAt(i);
                slidingWindow.putIfAbsent(curChar, 0);
                slidingWindow.put(curChar, slidingWindow.get(curChar) + 1);
                // move left pointer until, the map.size() == maxLetters
                while(slidingWindow.size() > maxLetters){
                    helper(s, left++, slidingWindow);
                }
                if (i - left + 1 > minSize){
                    helper(s, left++, slidingWindow);
                }
                if (i - left + 1 == minSize){
                    String subString = s.substring(left, i + 1);
                    subOccurences.putIfAbsent(subString, 0);
                    subOccurences.put(subString, subOccurences.get(subString) + 1);
                    result = Math.max(result, subOccurences.get(subString));
                }
            }
            return result;
        }
        private void helper(String s, int left, Map<Character, Integer> slidingWindow){
            if (slidingWindow.get( s.charAt(left) ) == 1 ){
                slidingWindow.remove( s.charAt(left) );
            }
            else{
                slidingWindow.put( s.charAt(left), slidingWindow.get( s.charAt(left) ) - 1);
            }
        }
    }

    class Solution2 {
        public int maxFreq(String input, int maxLetters, int minSize, int maxSize){
            int left = 0;
            int maxCount = 0;

            Map<Character, Integer> charCount = new HashMap<>();

            Map<String, Integer> substringOccurance = new HashMap<>();

            int uniqueCharCount = 0;
            for (int i = 0; i < input.length(); i++){
                char curChar = input.charAt(i);

                if (uniqueCharCount < maxLetters){
                    charCount.putIfAbsent(curChar, 0);
                    if (charCount.get(curChar) == 0){
                        uniqueCharCount++;
                    }
                    charCount.put(curChar, charCount.get(curChar) + 1);
                }
                else{
                    charCount.putIfAbsent(curChar, 0);
                    if (charCount.get(curChar) == 0){
                        //move left to free 1 unique char
                        while(charCount.get(input.charAt(left) ) > 0  ){
                            charCount.put(input.charAt(left), charCount.get(input.charAt(left)) - 1 );
                            if ( charCount.get(input.charAt(left)) == 0 ){
                                left++;
                                break;
                            }
                            left++;
                        }
                    }
                    charCount.put(curChar, charCount.get(curChar) + 1);
                }

                if (i - left + 1 >= minSize){
                    String curSub = input.substring(i - minSize + 1, i - minSize + 1 + minSize);
                    substringOccurance.put(curSub, substringOccurance.getOrDefault(curSub, 0) + 1);
                    maxCount = Math.max(maxCount, substringOccurance.get(curSub));
                }
            }
            return maxCount;
        }
    }
}