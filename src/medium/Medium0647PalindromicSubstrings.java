package medium;

public class Medium0647PalindromicSubstrings {
    public static void main(String[] args) {
        Medium0647PalindromicSubstrings thisClass = new Medium0647PalindromicSubstrings();
        System.out.println (thisClass.countSubstrings(null));
    }
    public int countSubstrings2(String s) {
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

    private int _counter = 0;
    public int countSubstrings(String s) {
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++){
            // index i is in the center and palindrome is odd number
            _counter++;
            count(charArray, i, i);
            // index i is at the center left and palindrome is even number
            if ((i +1 < charArray.length) && charArray[i] == charArray[i+1] )
            {
                _counter++;
                count(charArray, i, i+1);
            }
        }
        return _counter;
    }

    private void count(char[] charArray, int a, int b){
        int n = 1;
        while (a-n >=0 && b+n< charArray.length){
            if(charArray[a-n] == charArray[b+n]){
                _counter++;
            }
            else{
                break;
            }
            n++;
        }
    }

    class Solution {
        public int countSubstrings(String s) {
            int len = s.length();
            int result = 0;
            for (int i = 0; i < len; i++){
                int count = 0;
                while( i + count < len && i - count >= 0 && s.charAt(i + count) == s.charAt(i - count) )
                {
                    result++;
                    count++;
                }
            }
            for (int i = 0; i < len - 1; i++){
                int count = 0;
                while( i + count + 1 < len && i - count >= 0 && s.charAt(i + count + 1) == s.charAt(i - count) )
                {
                    result++;
                    count++;
                }
            }
            return result;
        }
    }
}