package medium;

import java.util.*;

public class Medium0316RemoveDuplicateLetters {

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

    class Solution1 {
        public String removeDuplicateLetters(String s) {
            Set<Character> inStack = new HashSet<>();
            Stack<Character> stack = new Stack<>();
            int[] map = new int[26];
            for (char curChar : s.toCharArray()){
                map[curChar - 'a']++;
            }
            for (char curChar : s.toCharArray()){
                if (!inStack.contains(curChar)){
                    while(!stack.isEmpty() && map[stack.peek() - 'a'] > 0 && curChar < stack.peek()){
                        inStack.remove(stack.pop());
                    }
                    stack.push(curChar);
                    inStack.add(curChar);
                }
                map[curChar - 'a']--;
            }
            StringBuilder sb = new StringBuilder();
            while(!stack.isEmpty()){
                sb.append(stack.pop());
            }
            return sb.reverse().toString();
        }
    }
}