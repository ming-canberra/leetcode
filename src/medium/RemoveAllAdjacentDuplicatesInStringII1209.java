package medium;
import java.util.Stack;
public class RemoveAllAdjacentDuplicatesInStringII1209 {
    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesInStringII1209 thisClass = new RemoveAllAdjacentDuplicatesInStringII1209();
    }
    private static final int OPEN = -1;
    public String removeDuplicates(String s, int k) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        if (s.length() == 1){
            return s;
        }
        sb.append(s.charAt(0));
        stack.push(1);
        for (int i = 1; i < s.length(); i++){
            if (sb.length() > 0){
                if (sb.charAt(sb.length() - 1) != s.charAt(i)){
                    stack.push(1);
                    sb.append(s.charAt(i));
                }
                // prev char == current char
                else{
                    int top = stack.pop();
                    if (top + 1 == k){
                        sb.delete(sb.length() - k + 1, sb.length());
                    }
                    else{
                        sb.append(s.charAt(i));
                        stack.push(top + 1);
                    }
                }
            }
            else{
                sb.append(s.charAt(i));
                stack.push(1);
            }
        }
        return sb.toString();
    }
}