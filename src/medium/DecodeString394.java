package medium;

import java.util.*;

public class DecodeString394 {

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
}