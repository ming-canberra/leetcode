package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class UncommonWordsFromTwoSentences884 {
    public static void main(String[] args) {
        UncommonWordsFromTwoSentences884 thisClass = new UncommonWordsFromTwoSentences884();
        String[] a = thisClass.uncommonFromSentences("","");
            System.out.println(a);
    }
    public String[] uncommonFromSentences(String a, String b) {

        HashMap<String, Integer> aMap = new HashMap<String, Integer>();

        for (String s : a.split(" ")){
            aMap.put(s, 1 + aMap.getOrDefault(s, 0));
        }

        HashMap<String, Integer> bMap = new HashMap<String, Integer>();

        for (String s : b.split(" ")){
            bMap.put(s, 1 + bMap.getOrDefault(s, 0));
        }

        ArrayList<String> ans = new ArrayList<String>();

        for (String s : aMap.keySet()){
            if (aMap.get(s) == 1 && !bMap.containsKey(s)){
                ans.add(s);
            }
        }

        for (String s : bMap.keySet()){
            if (bMap.get(s) == 1 && !aMap.containsKey(s)){
                ans.add(s);
            }
        }

        return ans.toArray(new String[ans.size()]);
    }
}