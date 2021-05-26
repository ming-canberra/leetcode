package medium;

import java.util.*;

public class MinimumRemoveToMakeValidParentheses1249 {
    public static void main(String[] args) {
        MinimumRemoveToMakeValidParentheses1249 thisClass = new MinimumRemoveToMakeValidParentheses1249();
    }

    /**
     * O(N)
     * */
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int open = 0;
        for (char c : s.toCharArray()){
            if (c == '('){
                open++;
            }
            else if (c == ')'){
                if (open >0)
                {
                    open--;
                }
                else{
                    continue;
                }
            }
            sb.append(c);
        }
        if (open == 0){
            return sb.toString();
        }
        else{
            StringBuilder result = new StringBuilder();
            for (int i = sb.length() - 1; i >= 0; i--){
                if(open > 0 && sb.charAt(i) == '('){
                    open--;
                    continue;
                }
                result.append(sb.charAt(i));
            }
            return result.reverse().toString();
        }
    }

    /**
     * time O(N)
     * space O(N)
     * */
    public String minRemoveToMakeValid2(String s) {
        Stack<CharIndex> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char curChar = s.charAt(i);

            if (curChar == '('){
                stack.push(new CharIndex(curChar, i));
            }
            else if (curChar == ')'){

                if (stack.isEmpty()){
                    stack.push(new CharIndex(curChar, i));
                }
                else{
                    CharIndex tmp = stack.peek();
                    if (tmp.c == '('){
                        stack.pop();
                    }
                    else{
                        stack.push(new CharIndex(curChar, i));
                    }
                }
            }
        }
        Set<Integer> indexSet = new HashSet<>();
        while (!stack.isEmpty()){
            indexSet.add(stack.pop().index);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            char curChar = s.charAt(i);
            if (!indexSet.contains(i)){
                sb.append(curChar);
            }
        }
        return sb.toString();
    }
    class CharIndex{
        char c;
        int index;
        CharIndex (char cValue, int indexValue){
            c = cValue;
            index = indexValue;
        }
    }
}