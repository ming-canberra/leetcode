package medium;

import java.util.*;

public class LongestSubstringwithAtMostTwoDistinctCharacters159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int left = 0;// window contains the longest substring
        int result = 1;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++){
            Character curChar = s.charAt(right);
            if (map.containsKey(curChar)){
                map.put(curChar, map.get(curChar) + 1);
                result = Math.max(result, right - left + 1);
            }
            else{
                if (map.size() == 2){
                    while(left < right && map.containsKey(s.charAt(left) )  ){
                        Integer count = map.get(s.charAt(left));
                        if (count == 1){
                            map.remove(s.charAt(left));
                            left++;
                            break;
                        }
                        else{
                            map.put(s.charAt(left), count - 1);
                        }
                        left++;
                    }
                }
                map.put(curChar, 1);
                result = Math.max(result, right - left + 1);
            }
        }
        return result;
    }
}