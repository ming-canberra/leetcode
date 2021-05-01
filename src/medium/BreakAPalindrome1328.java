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
}