package easy;

import java.util.HashMap;
import java.util.HashSet;

public class JewelsandStones771 {
    public static void main(String[] args) {
        JewelsandStones771 thisClass = new JewelsandStones771();
        System.out.println(thisClass.numJewelsInStones("aA","aAAbbbb"));
    }
    public int numJewelsInStones(String jewels, String stones) {

        HashSet<Character> set = new HashSet<Character>();

        for (char c : jewels.toCharArray()){
            set.add(c);
        }
        int counter = 0;
        for (char c : stones.toCharArray()){
            if(set.contains(c)){
                counter++;
            }
        }

        return counter;
    }
}