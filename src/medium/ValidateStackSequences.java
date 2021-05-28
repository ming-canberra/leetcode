package medium;

import java.util.*;

public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int pushedIndex = 0;
        int poppedIndex = 0;
        int pushedLength = pushed.length;
        int poppedLength = popped.length;
        while(pushedIndex < pushedLength && poppedIndex < poppedLength){
            if(stack.isEmpty()){
                stack.push(pushed[pushedIndex]);
                pushedIndex++;
            }
            else{
                int top = stack.peek();
                if (top == popped[poppedIndex]){
                    poppedIndex++;
                    stack.pop();
                }
                else{
                    stack.push(pushed[pushedIndex]);
                    pushedIndex++;
                }
            }
        }
        while (!stack.isEmpty()){
            int top = stack.peek();
            if (top == popped[poppedIndex]){
                poppedIndex++;
                stack.pop();
            }
            else{
                return false;
            }
        }
        return true;
    }
}