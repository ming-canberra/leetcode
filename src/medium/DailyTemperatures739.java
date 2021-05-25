package medium;

import java.util.*;

public class DailyTemperatures739 {
    public static void main(String[] args) {
        DailyTemperatures739 thisClass = new DailyTemperatures739();

        thisClass.dailyTemperatures(null);
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] dist = new int[n];
        Stack<Integer> indexs = new Stack<>();
        for (int curIndex = 0; curIndex < n; curIndex++) {
            while (!indexs.isEmpty() && temperatures[curIndex] > temperatures[indexs.peek()]) {
                int preIndex = indexs.pop();
                dist[preIndex] = curIndex - preIndex;
            }
            indexs.add(curIndex);
        }
        return dist;
    }

    public int[] dailyTemperatures2(int[] temperatures) {
        int n = temperatures.length;

        int[] result = new int[n];

        Stack<Integer> stack = new Stack();

        for (int i = n - 1; i >= 0; i--){
            while(!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]){
                stack.pop();
            }
            int tmp = 0;
            if (!stack.isEmpty()){
                tmp = stack.peek() - i;
            }

            result[i] = tmp;

            stack.push(i);
        }

        return result;
    }
}