package medium;

import java.util.*;

public class Medium1647MinimumDeletionstoMakeCharacterFrequenciesUnique {
    class Solution {
        public int minDeletions(String s) {

            int[] charCount = new int[26];

            for (char charr : s.toCharArray()){
                charCount[ charr - 'a' ]++;
            }

            Map<Integer, Integer> frequencyCount = new HashMap<>();
            int maxCount = 0;

            for (int i = 0; i < charCount.length; i++){
                if (charCount[i] > 0){
                    int count = frequencyCount.getOrDefault(charCount[i], 0) + 1;
                    frequencyCount.put(charCount[i], count);
                    maxCount = Math.max(maxCount, charCount[i]);
                }
            }

            int result = 0;

            while(maxCount > 0){

                if (frequencyCount.containsKey(maxCount)){
                    if (frequencyCount.get(maxCount) > 1){
                        result = result + frequencyCount.get(maxCount) - 1;

                        int count = frequencyCount.getOrDefault(maxCount - 1, 0) + frequencyCount.get(maxCount) - 1;
                        frequencyCount.put(maxCount - 1, count);

                    }

                }
                maxCount--;
            }

            return result;
        }
    }
}