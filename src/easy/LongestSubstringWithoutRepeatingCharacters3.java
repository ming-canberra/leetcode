package easy;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters3 {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters3 thisClass = new LongestSubstringWithoutRepeatingCharacters3();
        System.out.println(" " + thisClass.lengthOfLongestSubstring("dvdf"));
    }
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
}