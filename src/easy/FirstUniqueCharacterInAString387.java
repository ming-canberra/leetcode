package easy;

import java.util.HashMap;
import java.util.HashSet;

public class FirstUniqueCharacterInAString387 {
    public static void main(String[] args) {
        FirstUniqueCharacterInAString387 thisClass = new FirstUniqueCharacterInAString387();

        int[] input = {1,2,3,0};
        int result = thisClass.firstUniqChar("loveleetcode");
        System.out.println(result);
    }

    public int firstUniqChar(String s) {
        if (s == null || s.equals("")){
            return -1;
        }

        HashMap<Character, Integer> hashSet = new HashMap<Character, Integer>();

        int toReturn = -1;
        for (int i = s.length() -1; i>= 0; i--){
            if (hashSet.containsKey(s.charAt(i))){
                hashSet.put(s.charAt(i), -1);
            }
            else{
                hashSet.put(s.charAt(i), i);
            }
        }

        for (Integer i : hashSet.values()){
            if (i > -1){
                if (toReturn == -1){
                    toReturn = i;
                }
                else {
                    if (i < toReturn){
                        toReturn = i;
                    }
                }
            }
        }

        return toReturn;
    }
}