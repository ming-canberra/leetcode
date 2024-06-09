package medium;

import java.util.*;

public class Medium0394DecodeString {

    /**
     *  O(N * digit_repeat_max)
     * */
    class Solution {
        public String decodeString(String s) {
            // int[] is to store count and index
            Stack<int[]> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();
            int index = 0;
            while (index < s.length()){
                char curChar = s.charAt(index);
                if ( curChar >= '1' && curChar <= '9'){
                    int digitStart = index;
                    while(s.charAt(index) !='['){
                        index++;
                    }
                    stack.push(new int[]{ Integer.parseInt(s.substring(digitStart, index)), sb.length()});
                }
                else if (curChar == ']'){
                    int[] top = stack.pop();
                    int letterStartIndex = top[1];
                    String toCopy = sb.substring(letterStartIndex, sb.length());

                    for (int i = 1; i < top[0]; i++){
                        sb.append(toCopy);
                    }
                }
                else{
                    sb.append(curChar);
                }
                index++;

            }
            return sb.toString();
        }
    }

    class Solution1 {
        public String decodeString(String s) {
            StringBuilder sb = new StringBuilder();
            // first element for number of repetition
            // second element for starting idx for duplicating
            Stack<int[]> stack = new Stack<>();
            int idx = 0;
            while(idx < s.length()) {
                char cChar = s.charAt(idx);

                if (Character.isDigit(cChar)) {
                    // iterate until '['
                    StringBuilder intSb = new StringBuilder();
                    while(s.charAt(idx) != '[') {
                        intSb.append(s.charAt(idx));
                        idx++;
                    }
                    stack.push(new int[]{Integer.valueOf(intSb.toString()), sb.length() });
                }
                else if (cChar == ']') {
                    //pop the stack
                    int[] intArray = stack.pop();
                    int length = sb.length();
                    for (int i = 1; i < intArray[0]; i++) {

                        sb.append(sb.substring(intArray[1] , length));

                    }
                }
                // any letter
                else {
                    sb.append(cChar);
                }

                idx++;
            }

            return sb.toString();
        }
    }

    class Solution2 {
        public String decodeString(String s) {
            StringBuilder sb = new StringBuilder();

            Deque<String> stackString = new LinkedList<>();
            Deque<Integer> stackMultiplier = new LinkedList<>();

            int multiplier = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c >= '0' && c <= '9') {
                    multiplier = multiplier * 10 + (c - '0');
                }
                else if (c == '[') {
                    stackString.addLast(sb.toString());
                    stackMultiplier.addLast(multiplier);
                    multiplier = 0;
                    sb = new StringBuilder();
                }
                else if (c == ']') {
                    StringBuilder tmp = new StringBuilder();
                    int top = stackMultiplier.removeLast();
                    for (int j = 0; j < top; j++) {
                        tmp.append(sb.toString());
                    }
                    sb = new StringBuilder(stackString.removeLast() + tmp);
                }
                else {
                    sb.append(c);
                }
            }

            return sb.toString();
        }
    }
}