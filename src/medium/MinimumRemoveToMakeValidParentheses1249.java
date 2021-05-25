package medium;

import java.util.HashSet;

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
}