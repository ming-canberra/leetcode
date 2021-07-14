package medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        generate(result,"", n, n, n);
        return result;
    }
    private void generate(List<String> result, String string, int numOpen, int numClose, int n){
        if(string.length() == n * 2){
            result.add(string);
        }
        else{
            if (numOpen == numClose){
                generate(result, string + "(", numOpen - 1, numClose, n);
            }
            else if (numOpen < numClose){
                if (numOpen > 0){
                    generate(result, string + "(", numOpen - 1, numClose, n);
                }
                generate(result, string + ")", numOpen, numClose - 1, n);
            }
        }
    }

    class Solution {
        private List<String> result;
        public List<String> generateParenthesis(int n) {
            result = new ArrayList<>();
            addP("(", n - 1, n);
            return result;
        }
        private void addP(String cur, int open, int close){
            if (open == 0 && close == 0){
                result.add(cur);
                return;
            }
            if (open < 0 || close < 0){
                return;
            }
            if (open > close){
                return;
            }
            addP(cur + "(", open - 1, close);
            addP(cur + ")", open, close - 1);
        }
    }
}