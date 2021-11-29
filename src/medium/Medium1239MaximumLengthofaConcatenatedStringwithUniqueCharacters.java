package medium;

import java.util.*;

public class Medium1239MaximumLengthofaConcatenatedStringwithUniqueCharacters {
    class Solution {
        public int maxLength(List<String> arr) {

            int result = 0;

            List<List<String>> uniqueString = new ArrayList<>();

            for (int i = 0; i < arr.size(); i++){
                String stringInArr = arr.get(i);

                List<String> stringListEndingWithStringInArr = new ArrayList<>();

                String combinedStringInArr = combine("", stringInArr);
                if (combinedStringInArr != null){
                    result = Math.max(result, stringInArr.length());

                    for (int j = 0; j < i; j++){

                        String curCombined = combine(arr.get(j), stringInArr);
                        if (curCombined != null){
                            stringListEndingWithStringInArr.add(curCombined);
                            result = Math.max(result, curCombined.length());
                            for (String prevString : uniqueString.get(j)){
                                String tmp = combine(prevString, stringInArr);
                                if (tmp != null){
                                    stringListEndingWithStringInArr.add(tmp);
                                    result = Math.max(result, tmp.length());
                                }
                            }
                        }
                    }
                }
                uniqueString.add(stringListEndingWithStringInArr);
            }
            return result;
        }

        private String combine(String front, String back){
            int[] charCount = new int[26];
            for (char cc : front.toCharArray()){
                int idx = cc - 'a';
                if (charCount[idx] > 0){
                    return null;
                }
                else{
                    charCount[idx]++;
                }
            }
            for (char cc : back.toCharArray()){
                int idx = cc - 'a';
                if (charCount[idx] > 0){
                    return null;
                }
                else{
                    charCount[idx]++;
                }
            }
            return front + back;
        }
    }
}