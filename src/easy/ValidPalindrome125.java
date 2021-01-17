package easy;

public class ValidPalindrome125 {
    public static void main(String[] args) {
        ValidPalindrome125 thisClass = new ValidPalindrome125();


        System.out.println(

                " " +
                thisClass.isPalindrome("A man, a plan, a canal: Panama")
        );
    }
    public boolean isPalindrome(String s) {

        String cleaned = s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (cleaned == "")
            return true;

        int leftIndex = 0;
        int rightIndex = cleaned.length() -1;
        char[] chars = cleaned.toCharArray();
        while (leftIndex < rightIndex){
            if (chars[leftIndex] == chars[rightIndex]){
                leftIndex++;
                rightIndex--;
            }
            else
                return false;
        }


        return true;
    }
}