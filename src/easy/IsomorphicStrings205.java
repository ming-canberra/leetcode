package easy;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

public class IsomorphicStrings205 {
    public static void main(String[] args) {
        IsomorphicStrings205 thisClass = new IsomorphicStrings205();

        System.out.println(thisClass.isIsomorphic("paper", "title"));
    }
    public boolean isIsomorphic(String s, String t) {
        // key is from s, value is from t
        HashMap<Character, Character> sToTMap = new HashMap<Character, Character>();

        char[] sChars = s.toCharArray();
        for (int i = 0;i < sChars.length;i++){

            if (sToTMap.containsKey(s.charAt(i))){

                if (t.charAt(i) != sToTMap.get(s.charAt(i))){
                    return false;
                }
            }
            else{
                if (sToTMap.containsValue(t.charAt(i))){
                    return false;
                }
                else {
                    sToTMap.put(s.charAt(i), t.charAt(i));
                }
            }
        }

        return true;
    }
}