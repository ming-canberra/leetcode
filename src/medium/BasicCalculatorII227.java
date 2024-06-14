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

    class Solution1 {
        public int calculate(String s) {
            char operator = '+';
            StringBuilder sb = new StringBuilder();
            Stack<Integer> stack = new Stack<>();

            for (int index = 0; index < s.length(); index++){
                if (s.charAt(index) == ' '){

                }
                else if ( Character.isDigit(s.charAt(index)) ){
                    sb.append(s.charAt(index));
                }

                if (index == s.length() - 1 || s.charAt(index) == '+' || s.charAt(index) == '-' || s.charAt(index) == '*' || s.charAt(index) == '/' ){
                    int curInt = Integer.valueOf(sb.toString());
                    if (operator == '+'){
                        stack.push(curInt);
                    }
                    else if (operator == '-'){
                        stack.push(-1 * curInt);
                    }
                    else if (operator == '*'){
                        stack.add(stack.pop() * curInt);
                    }
                    else if (operator == '/'){
                        stack.add(stack.pop() / curInt);
                    }
                    sb = new StringBuilder();

                    operator = s.charAt(index);
                }
            }

            int result = 0;

            while(!stack.isEmpty()){
                result += stack.pop();
            }


            return result;
        }
    }

    class Solution2 {
        public int calculate(String s) {
            Stack<Integer> stack = new Stack<>();
            s = s.replace(" ", "");
            int currentValue = 0;
            char prevOperator = ' ';
            for (int i = 0; i < s.length(); i++) {
                char aChar = s.charAt(i);
                if (aChar >= '0' && aChar <= '9') {
                    currentValue = 10 * currentValue + aChar - '0';
                }
                if (i == s.length() - 1 || aChar < '0' || aChar > '9')
                {
                    if (prevOperator == '*') {
                        currentValue = stack.pop() * currentValue;
                        stack.push(currentValue);
                    }
                    else if (prevOperator == '/') {
                        currentValue = stack.pop() / currentValue;
                        stack.push(currentValue);
                    }
                    else if (prevOperator == '+') {
                        stack.push(currentValue);
                    }
                    else if (prevOperator == '-') {
                        stack.push(-1 * currentValue);
                    }
                    else {
                        stack.push(currentValue);
                    }

                    currentValue = 0;

                    prevOperator = aChar;
                }

            }
            while(!stack.isEmpty()) {
                currentValue += stack.pop();
            }
            return currentValue;
        }
    }
}