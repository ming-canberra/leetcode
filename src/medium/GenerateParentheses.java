package medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        GenerateParentheses thisClass = new GenerateParentheses();
        List<String> res = thisClass.generateParenthesis(5);
        System.out.println(res.size());
    }
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
}