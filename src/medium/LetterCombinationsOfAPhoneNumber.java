package medium;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber thisClass = new LetterCombinationsOfAPhoneNumber();

        List<String> res = thisClass.letterCombinations("");
        System.out.println(res);
    }

    public List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<String>();
        if (digits == null || digits.isEmpty()){
            return result;
        }
        HashMap<Character, String[]> map = new HashMap<Character, String[]>();
        map.put('2', new String[]{"a", "b", "c"});
        map.put('3', new String[]{"d", "e", "f"});
        map.put('4', new String[]{"g", "h", "i"});
        map.put('5', new String[]{"j", "k", "l"});
        map.put('6', new String[]{"m", "n", "o"});
        map.put('7', new String[]{"p", "q", "r", "s"});
        map.put('8', new String[]{"t", "u", "v"});
        map.put('9', new String[]{"w", "x", "y", "z"});
        for (String s : map.get(digits.charAt(0))){
            result.add(s);
        }
        for (int i = 1; i < digits.length(); i++){
            String[] mappedStringArray = map.get(digits.charAt(i));
            int resultSize = result.size();
            for (int j = 0; j < resultSize; j++){
                String top = result.poll();
                for (String suffix : mappedStringArray){
                    result.add(top + suffix);
                }
            }
        }
        return result;
    }
}