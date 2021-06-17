package medium;

import java.util.*;

public class BasicCalculatorII227 {
    class Solution {
        public int calculate(String s) {
            Stack<Integer> stack = new Stack<>();
            //the key is to apply previous op first, then set the current op value to the previous op represented by the char in current iteration
            char preOp = '+';
            int curInt = 0;
            s = s.replace(" ", "");
            for (int i = 0; i < s.length(); i++){
                char curChar = s.charAt(i);
                if (Character.isDigit(curChar)){
                    curInt = 10 * curInt + curChar - '0';
                }
                if (!Character.isDigit(curChar) || i == s.length() - 1){
                    if (preOp == '+'){
                        stack.push(curInt);
                    }
                    else if (preOp == '-'){
                        stack.push(-curInt);
                    }
                    else if (preOp == '*'){
                        stack.push(curInt * stack.pop());
                    }
                    else if (preOp == '/'){
                        stack.push(stack.pop() / curInt);
                    }
                    preOp = curChar;
                    curInt = 0;
                }
            }
            int result = 0;
            while (!stack.isEmpty()){
                result += stack.pop();
            }

            return result;
        }
    }


}