package hard;

import java.util.*;

public class Hard0772BasicCalculatorIII {

    class Solution {
        public int calculate(String s) {
            Stack<Integer> stack = new Stack<>();
            char operator = '+';
            StringBuilder sb = new StringBuilder();
            for (int index = 0; index < s.length(); index++){
                char curChar = s.charAt(index);

                if (Character.isDigit(curChar)){
                    sb.append(curChar);
                }
                else if ( curChar == '(' ){
                    // get a new sub string for the current ();
                    String newString = extractCurlyWrapperString(s, index + 1);
                    sb = new StringBuilder();
                    sb.append(calculate(newString) );
                    index += newString.length() + 1;
                }
                if (index == s.length() - 1 || curChar == '+' || curChar == '-' || curChar == '*' || curChar == '/')
                {
                    int curValue = Integer.valueOf( sb.toString() );
                    sb = new StringBuilder();
                    if (operator == '+'){
                        stack.push(curValue);
                    }
                    else if (operator == '-'){
                        stack.push(-1 * curValue);
                    }
                    else if (operator == '*'){
                        stack.push( stack.pop() * curValue );
                    }
                    else if (operator == '/'){
                        stack.push( stack.pop() / curValue );
                    }
                    operator = curChar;
                }
            }
            int result = 0;
            while(!stack.isEmpty()){
                result += stack.pop();
            }
            return result;
        }
        private String extractCurlyWrapperString(String s, int sIndex){
            Stack<Character> stack = new Stack<>();
            for (int i = sIndex; i < s.length(); i++){
                char curChar = s.charAt(i);
                if (curChar == '('){
                    stack.push(curChar);
                }
                else if (curChar == ')'){
                    if (stack.isEmpty()){
                        return s.substring(sIndex, i);
                    }
                    else{
                        stack.pop();
                    }
                }
            }
            return "";
        }
    }
}