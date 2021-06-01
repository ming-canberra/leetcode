package medium;

import java.util.*;

public class RemoveDuplicateLetters316 {

    /**
     *  O(N)
     * */

    class Solution {
        public String removeDuplicateLetters(String s) {
            HashSet<Character> set = new HashSet<>();
            Stack<Character> stack = new Stack<>();
            HashMap<Character, Integer> charIndex = new HashMap<Character, Integer>();
            char[] arr = s.toCharArray();
            for (int i = s.length() - 1; i >= 0; i--){
                if (!charIndex.containsKey(arr[i])){
                    charIndex.put(arr[i], i);
                }
            }
            for (int i = 0; i < s.length(); i++){
                if (stack.isEmpty()){
                    stack.push(arr[i]);
                    set.add(arr[i]);
                }
                else{
                    while(!stack.isEmpty() && stack.peek() > arr[i] && !set.contains(arr[i]) && charIndex.get(stack.peek()) > i ){
                        set.remove(stack.peek());
                        stack.pop();
                    }
                    if (!set.contains(arr[i])){
                        stack.push(arr[i]);
                        set.add(arr[i]);
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for (char c : stack){
                sb.append(c);
            }
            return sb.toString();
        }
    }
}