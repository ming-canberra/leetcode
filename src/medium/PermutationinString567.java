package medium;

import java.util.*;

public class PermutationinString567 {
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            String sShort = s1;
            String sLong = s2;
            int[] shortArray = new int[26];
            for (char c : sShort.toCharArray()){
                shortArray[c - 'a']++;
            }
            if (sLong.length() < sShort.length() ){
                return false;
            }
            int[] longArray = new int[26];
            for (int i = 0; i <= sLong.length() - sShort.length(); i++){
                if (i == 0){
                    for (int j = 0; j < sShort.length(); j++){
                        longArray[sLong.charAt(j) - 'a']++;
                    }
                }
                else{
                    longArray[sLong.charAt(i - 1) - 'a']--;
                    longArray[sLong.charAt(i + sShort.length() - 1) - 'a']++;
                }
                if (Arrays.equals(shortArray, longArray)){
                    return true;
                }
            }
            return false;
        }
    }

    class Solution1 {
        public boolean checkInclusion(String s1, String s2) {
            if (s1.length() > s2.length()){
                return false;
            }
            int[] sMap = new int[26];
            int[] bMap = new int[26];
            for (int i = 0; i < s1.length(); i++){
                sMap[s1.charAt(i) - 'a']++;
                bMap[s2.charAt(i) - 'a']++;
            }
            if(Arrays.equals(sMap, bMap)){
                return true;
            }
            for (int i = s1.length(); i < s2.length(); i++){
                bMap[s2.charAt(i) - 'a']++;
                bMap[s2.charAt(i - s1.length()) - 'a']--;
                if(Arrays.equals(sMap, bMap)){
                    return true;
                }
            }
            return false;
        }
    }
}