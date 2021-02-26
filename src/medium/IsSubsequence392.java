package medium;

public class IsSubsequence392 {
    public static void main(String[] args) {
        IsSubsequence392 thisClass = new IsSubsequence392();
        boolean res = thisClass.isSubsequence("b", "c");
        System.out.println(res);
    }
    public boolean isSubsequence(String s, String t) {
        if (s==null || s.length() == 0){
            return true;
        }
        int i=0;
        int j =0;
        for (i = 0; i < s.length() && j < t.length(); i++){
            if (s.charAt(i) == t.charAt(j)){
                j++;
            }
            else{
                j++;
                while (j < t.length() && s.charAt(i) != t.charAt(j)){
                    j++;
                }
                if (j == t.length())
                {
                    return false;
                }
                j++;
            }
            if (i == s.length() -1)
            {
                return true;
            }
        }

        return false;
    }
}