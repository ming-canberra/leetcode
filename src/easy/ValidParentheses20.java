package easy;

import java.util.*;

public class ValidParentheses20 {
    public static void main(String[] args) {
        ValidParentheses20 thisClass = new ValidParentheses20();
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if (stack.isEmpty()){
                stack.push(c);
            }
            else{
                Character top = stack.peek();

                if (top == '(' && c == ')'){
                    stack.pop();
                }
                else if (top == '[' && c == ']'){
                    stack.pop();
                }
                else if (top == '{' && c == '}'){
                    stack.pop();
                }
                else{
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }
}