package medium;

import java.util.*;

public class ScoreOfParentheses856 {
    public static void main(String[] args) {
        ScoreOfParentheses856 thisClass = new ScoreOfParentheses856();
    }
    private static final int OPEN = -1;
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        for ( char c : s.toCharArray()){
            if (stack.isEmpty()){
                stack.push(OPEN);
            }
            else{
                if ( c == '('){
                    stack.push(OPEN);
                }
                else{
                    int top = stack.pop();
                    if (top == OPEN){
                        stack.push(1);
                    }
                    else{
                        int sum = 0;
                        while (top != OPEN){
                            sum += top;
                            top = stack.pop();
                        }
                        stack.push(sum * 2);
                    }
                }
            }
        }
        int result = 0;
        while (!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }
}