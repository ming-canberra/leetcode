package medium;

import java.util.*;

public class OnlineStockSpan901 {
    public static void main(String[] args) {
        OnlineStockSpan901 thisClass = new OnlineStockSpan901();
    }

    class StockSpanner {
        private Stack<int[]> stack;
        public StockSpanner() {
            stack = new Stack<>();
        }
        public int next(int price) {
            if (stack.isEmpty()){
                stack.push(new int[]{price, 1});
                return 1;
            }
            else{
                int sum = 0;
                while (!stack.isEmpty()){
                    int[] tmp = stack.peek();
                    if (tmp[0] <= price){
                        sum += tmp[1];
                        stack.pop();
                    }
                    else{
                        break;
                    }
                }
                stack.push(new int[]{price, sum + 1});
                return sum + 1;
            }
        }
    }
}