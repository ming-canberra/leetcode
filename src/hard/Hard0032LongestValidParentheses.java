package hard;

import java.util.Stack;

public class Hard0032LongestValidParentheses {
    class Solution {
        public int longestValidParentheses(String s) {
            int result = 0;
            Stack<String> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++){
                char curChar = s.charAt(i);
                int curCount = 0;
                if (!stack.isEmpty() && ( !"(".equals(stack.peek()) && !")".equals(stack.peek())  )) {
                    curCount = Integer.valueOf(stack.pop());
                }
                String toPushIn = null;
                if (!stack.isEmpty() ){
                    String topChar = stack.peek();
                    if (topChar.equals("(") && curChar == ')'){
                        curCount += 2;
                        stack.pop();
                    }
                    else{
                        toPushIn = String.valueOf(curChar);
                    }
                }
                else{
                    toPushIn = String.valueOf(curChar);
                }
                if (curCount > 0){


                    if (!stack.isEmpty() && ( !"(".equals(stack.peek()) && !")".equals(stack.peek())  )) {
                        curCount += Integer.valueOf(stack.pop());
                    }
                    result = Math.max(result, curCount);

                    stack.push(  String.valueOf(curCount));
                }
                if (toPushIn != null){
                    stack.push(toPushIn);
                }
            }
            return result;
        }
    }
}