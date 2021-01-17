package easy;

import java.util.HashMap;
import java.util.HashSet;

public class UniqueMorseCodeWords804 {
    public static void main(String[] args) {
        UniqueMorseCodeWords804 thisClass = new UniqueMorseCodeWords804();
        System.out.println(thisClass.uniqueMorseRepresentations(new String[]{"gin","zen","gig","msg"}));
    }
    public int uniqueMorseRepresentations(String[] words) {
        String[]morse = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-."
                ,"---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> set = new HashSet<String>();
        for (String s : words){
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()){
                sb.append(morse[c-'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}