package easy;

import java.util.*;

public class DesignAStackWithIncrementOperation1381 {
    public static void main(String[] args) {
        DesignAStackWithIncrementOperation1381 thisClass = new DesignAStackWithIncrementOperation1381();
    }

    /**
     * time O(N)
     * */
    class CustomStack {

        private int[] arr;
        private Stack<Integer> stack;

        public CustomStack(int maxSize) {
            arr = new int[maxSize];
            stack = new Stack<Integer>();
        }

        public void push(int x) {
            if (stack.size() < arr.length){
                stack.push(x);
            }
        }

        public int pop() {
            if (stack.isEmpty()){
                return -1;
            }
            else{
                int size = stack.size();
                if (size != 1){
                    arr[size - 2] += arr[size - 1];
                }
                int result = stack.pop();
                result += arr[size - 1];
                arr[size - 1] = 0;
                return result;
            }
        }

        public void increment(int k, int val) {
            int min = Math.min(k, stack.size());
            if (min > 0){
                arr[min - 1] += val;
            }
        }
    }
}