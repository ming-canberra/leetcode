package medium;

import java.util.*;

public class Medium150EvaluateReversePolishNotation {
    class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();
            for (String s : tokens){
                if ("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s)){
                    Integer right = stack.pop();
                    Integer left = stack.pop();
                    if ("+".equals(s)){
                        stack.push(left + right);
                    }
                    else if ("-".equals(s)){
                        stack.push(left - right);
                    }
                    else if ("*".equals(s)){
                        stack.push(left * right);
                    }
                    else{
                        stack.push(left / right);
                    }
                }
                else{
                    stack.push(Integer.valueOf(s));
                }
            }
            return stack.peek();
        }
    }
}