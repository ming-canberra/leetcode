package medium;

import java.util.*;

public class Medium1347MinimumNumberofStepstoMakeTwoStringsAnagram {

    class Solution {
        public int minSteps(String s, String t) {
            int[] sCount = new int[26];
            int[] tCount = new int[26];
            for (int i = 0; i < s.length(); i++){
                sCount[s.charAt(i) - 'a']++;
                tCount[t.charAt(i) - 'a']++;
            }
            int posDiff = 0;
            for (int i = 0; i < 26; i++){
                int diff = tCount[i] - sCount[i];
                if (diff > 0){
                    posDiff += diff;
                }
            }
            return posDiff;
        }
    }
}