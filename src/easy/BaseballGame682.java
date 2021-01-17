package easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BaseballGame682 {
    public static void main(String[] args) {
        BaseballGame682 thisClass = new BaseballGame682();
        System.out.println(thisClass.calPoints(new String[]{"5","2","C","D","+"}));
    }
    public int calPoints(String[] ops) {
        Stack<Integer> q = new Stack<Integer>();

        for (String s : ops){
            if ("+".equals(s))
            {
                Integer last = q.pop();
                Integer secondLast = q.peek();
                q.push(last);
                q.push(last + secondLast);
            }
            else if ("D".equals(s))
            {
                Integer last = q.peek();
                q.push(last * 2);
            }
            else if ("C".equals(s)){
                q.pop();
            }
            else{
                q.push( new Integer(s) );
            }
        }

        int sum =0;

        while (!q.isEmpty()){
            sum+=q.pop();
        }

        return sum;
    }
}