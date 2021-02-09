package easy;

import java.util.HashSet;

public class DIStringMatch942 {
    public static void main(String[] args) {
        DIStringMatch942 thisClass = new DIStringMatch942();
        int[] a = thisClass.diStringMatch("IDID");


        for (int i : a){
            System.out.println(i);
        }
    }

    public int[] diStringMatch(String s) {
        int[] ans = new int[s.length() + 1];
        int iValue = 0;
        int dValue = s.length();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == 'I'){
                ans[i] = iValue;
                iValue++;
                if (i == s.length() -1){
                    ans[i+1] = iValue;
                }
            }
            else{
                ans[i] = dValue;
                dValue--;
                if (i == s.length() -1){
                    ans[i+1] = dValue;
                }
            }
        }
        return ans;
    }
}