package easy;

import java.util.HashMap;
import java.util.HashSet;

public class VerifyingAnAlienDictionary953 {
    public static void main(String[] args) {
        VerifyingAnAlienDictionary953 thisClass = new VerifyingAnAlienDictionary953();
        int[][]input = new int[0][0];

        System.out.println(" " + thisClass.isAlienSorted(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
    }

    private HashMap<Character, Integer> _map = new HashMap<Character, Integer>();
    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < order.length(); i++){
            _map.put(order.charAt(i), i);
        }

        for (int i = 0; i < words.length - 1; i++){
            if (!lexicographical(words[i], words[i+1])){
                return false;
            }
        }

        return true;
    }

    private boolean lexicographical (String front, String rear){
        int commonLength = Math.min(front.length(), rear.length());
        boolean ans = true;
        for (int i = 0; i < commonLength; i ++){
            if (_map.get(front.charAt(i))<_map.get(rear.charAt(i))){
                ans = true;
                break;
            }
            if (_map.get(front.charAt(i))>_map.get(rear.charAt(i))){
                ans = false;
                break;
            }
        }

        if (front.startsWith(rear) && front.length() > rear.length()){
            ans = false;
        }

        return ans;
    }
}