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
}