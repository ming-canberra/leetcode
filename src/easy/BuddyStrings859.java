package easy;

import java.util.*;

public class BuddyStrings859 {
    public static void main(String[] args) {
        BuddyStrings859 thisClass = new BuddyStrings859();
        boolean a = thisClass.buddyStrings("aa","aa");
            System.out.println(a);
    }

    public boolean buddyStrings(String a, String b) {

        List<Integer> diffList = new ArrayList<Integer>();

        Set<Character> charSet = new HashSet<Character>();
        boolean atLeastTwoLetters = false;
        if (a.length() >= 2 && a.length() == b.length()){

            for (int i = 0; i < a.length(); i++){
                if (!atLeastTwoLetters ){

                    if (charSet.contains(a.charAt(i))){
                    atLeastTwoLetters = true;
                    }
                    else{
                        charSet.add(a.charAt(i));
                    }
                }
                if (a.charAt(i) != b.charAt(i)){
                    diffList.add(i);
                    if (diffList.size() >2){
                        return false;
                    }
                }
            }
            if (diffList.size() == 0 && atLeastTwoLetters){
                return true;
            }
            else if (diffList.size() == 2){
                if (a.charAt(diffList.get(0)) == b.charAt(diffList.get(1)) && b.charAt(diffList.get(0)) == a.charAt(diffList.get(1)) )
                    return true;
            }
            return false;

        }

        return false;
    }
}