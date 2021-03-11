package medium;

import easy.ListNode;

import java.util.ArrayList;
import java.util.List;

public class PalindromicSubstrings647 {
    public static void main(String[] args) {
        PalindromicSubstrings647 thisClass = new PalindromicSubstrings647();
        System.out.println (thisClass.countSubstrings(null));
    }
    public int countSubstrings(String s) {
        int toReturn = 0;
        for (int i = 0; i < s.length();i++){
            for (int j = i; j < s.length(); j++){
                if (isPalindromic(s.substring(i, j+1))){
                    toReturn++;
                }
            }
        }

        return toReturn;
    }

    private boolean isPalindromic(String s){
        if (s.length() == 1){
            return true;
        }
        char[] charArray = s.toCharArray();
        int i = 0;
        int j = charArray.length -1;
        while (j-i >= 1){
            if (charArray[i] != charArray[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}