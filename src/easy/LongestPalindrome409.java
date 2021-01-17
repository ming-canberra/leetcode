package easy;

import java.util.HashMap;

public class LongestPalindrome409 {
    public static void main(String[] args) {
        LongestPalindrome409 thisClass = new LongestPalindrome409();

        System.out.println(thisClass.longestPalindrome("abccccdd"));
    }
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> charFrequency = new HashMap<Character, Integer>();
        for (int i =0; i < s.length(); i++){
            if (charFrequency.containsKey(s.charAt(i))){
                charFrequency.put(s.charAt(i), charFrequency.get(s.charAt(i)) + 1);
            }
            else{
                charFrequency.put(s.charAt(i), 1);
            }
        }
        int toReturn = 0;
        boolean countSingleOnce = false;
        for (Integer integer : charFrequency.values()){
            if (integer % 2 == 0){
                toReturn += integer;
            }
            else {
                toReturn += integer - 1;
                if (countSingleOnce == false){
                    countSingleOnce = true;
                }
            }
        }
        if (countSingleOnce)
            toReturn = toReturn +1;
        return toReturn;
    }
}