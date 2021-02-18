package easy;

public class ValidPalindromeII680 {
    public static void main(String[] args) {
        ValidPalindromeII680 thisClass = new ValidPalindromeII680();

        System.out.println(
                " " +
                thisClass.validPalindrome("abc")
        );
    }
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() -1;
        while(l<r) {
            if (s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }
            else{
                break;
            }
        }
        if (l >= r)
            return true;
        else{
            return isPalindrome(s.substring(l+1, r + 1)) || isPalindrome(s.substring(l, r));
        }
    }

    private boolean isPalindrome(String s){
        int l = 0;
        int r = s.length() - 1;

        while(l<r){
            if (s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}