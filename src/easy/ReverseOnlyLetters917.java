package easy;

public class ReverseOnlyLetters917 {
    public static void main(String[] args) {
        ReverseOnlyLetters917 thisClass = new ReverseOnlyLetters917();
        System.out.println(" " + thisClass.reverseOnlyLetters("ab-cd"));
    }
    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j){
            while ( (i < j) && !Character.isLetter(chars[i])){
                i++;
            }
            while ( (i < j) && !Character.isLetter(chars[j])){
                j--;
            }
            if (i < j){
                char tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;
                i++;j--;
            }
        }

        return new String(chars);
    }
}