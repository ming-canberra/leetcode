package medium;

public class BreakAPalindrome1328 {
    public static void main(String[] args) {
        BreakAPalindrome1328 thisClass = new BreakAPalindrome1328();
        String res = thisClass.breakPalindrome("b");
        System.out.println(res);
    }
    public String breakPalindrome(String palindrome) {

        String s = palindrome;

        if (s.length() == 1)
        {
            return "";
        }

        char[] chars = palindrome.toCharArray();
        // even number
        if (s.length() % 2 == 0){
            for (int i = 0; i < chars.length; i++)
            {
                if (chars[i] != 'a')
                {
                    chars[i] = 'a';
                    return new String(chars);
                }
            }
            chars[chars.length - 1] = 'b';
            return new String(chars);
        }
        // odd number
        else
        {
            for (int i = 0; i < chars.length; i++){
                if (i != chars.length / 2)
                {
                    if (chars[i] != 'a'){
                        chars[i] = 'a';
                        return new String(chars);
                    }
                }
            }
            chars[chars.length - 1] = 'b';
            return new String(chars);
        }
    }


    class Solution {
        public String breakPalindrome(String palindrome) {
            if (palindrome.length() == 1){
                return "";
            }

            boolean even = palindrome.length() % 2 == 0;

            char[] charArray = palindrome.toCharArray();
            int index = 0;
            if (even){
                // replace the first char where it is not a, or replace the last char
                while(index < palindrome.length() && palindrome.charAt(index) == 'a'){
                    index++;
                }
                if (index == palindrome.length()){
                    charArray[charArray.length - 1] = 'b';
                    return new String(charArray);
                }
                else{
                    charArray[index] = 'a';
                    return new String(charArray);
                }
            }
            else{
                // replace the first char where it is not a and it is not he middle one, or replace the last char
                while( ( index < palindrome.length() && palindrome.charAt(index) == 'a')  || (index == palindrome.length() / 2 ) ){
                    index++;
                }
                if (index == palindrome.length()){
                    charArray[charArray.length - 1] = 'b';
                    return new String(charArray);
                }
                else{
                    charArray[index] = 'a';
                    return new String(charArray);
                }
            }

        }
    }
}