package medium;

import java.util.*;

public class Medium0402RemoveKDigits {

    /**
     * O(N)
     * O(N)
     * */
    class Solution1 {
        public String removeKdigits(String num, int k) {
            Stack<Character> stack = new Stack<>();
            char[] charArray = num.toCharArray();
            stack.push(charArray[0]);
            for (int i = 1; i < num.length(); i++){
                while(!stack.isEmpty() && k >0){
                    char top = stack.peek();
                    if (top > charArray[i]){
                        k--;
                        stack.pop();
                    }
                    else{
                        break;
                    }
                }
                if (charArray[i] == '0' && stack.isEmpty()){
                    // do not need leading 0
                }
                else{
                    stack.push(charArray[i]);
                }
            }
            while (k > 0 && !stack.isEmpty()){
                k--;
                stack.pop();
            }
            if (stack.isEmpty()){
                return "0";
            }
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()){
                sb.append(stack.pop());
            }
            return sb.reverse().toString();
        }
    }

    /**
     * O(N*k)
     * O(N)
     * */
    class Solution2 {
        StringBuilder sb = new StringBuilder();

        public String removeKdigits(String num, int k) {
            recur(num, k);
            String result = sb.toString();
            if (result.isEmpty()) {
                return "0";
            }

            // to remove leading 0
            int i = -1;
            while (i + 1 < result.length() && result.charAt(i + 1) == '0') {
                i++;
            }
            if (i + 1 < result.length()) {
                result = result.substring(i + 1);
                return result;
            } else {
                return "0";
            }
        }

        public void recur(String num, int k) {
            // search for the smallest during the first k + 1 char
            if (k == 0) {
                sb.append(num);
                return;
            }
            int length = num.length();
            if (k >= length) {
                sb.append("");
                return;
            }
            int minIndex = 0; // first index of min if there are multiple
            int min = 9;
            for (int i = 0; i <= k; i++) {
                if (num.charAt(i) == '0') {
                    if (i + 1 == length) {
                        sb.append("0");
                        return;
                    } else {
                        sb.append("0");
                        recur(num.substring(i + 1), k - i);
                        return;
                    }
                } else {
                    if (num.charAt(i) - '0' < min) {
                        min = num.charAt(i) - '0';
                        minIndex = i;
                    }
                }
            }

            if (minIndex + 1 == length) {
                sb.append(min);
            } else {
                sb.append(min);
                recur(num.substring(minIndex + 1), k - minIndex);
            }
        }
    }

    class Solution3 {
        public String removeKdigits(String num, int k) {
            int len = num.length();

            Stack<Character> stack = new Stack<>();
            stack.push(num.charAt(0));
            for (int i = 0; i < len; i++){
                char curChar = num.charAt(i);
                while (!stack.isEmpty() && curChar < stack.peek() && k > 0){
                    stack.pop();
                    k--;
                }
                stack.push(curChar);
            }

            while(k > 0){
                stack.pop();
                k--;
            }
            StringBuilder sb = new StringBuilder();

            List<Character> list = new ArrayList<>(stack);
            boolean canAppend = false;
            for (char cc : list){
                if (cc != '0'){
                    canAppend = true;
                }

                if (canAppend){
                    sb.append(cc);
                }

            }

            return sb.length() == 0 ? "0" : sb.toString();
        }
    }
}