package medium;

import java.util.*;

public class Hard0895MaximumFrequencyStack {
    class FreqStack {
        Map<Integer, Integer> valueFreMap = new HashMap<>();
        Map<Integer, Stack<Integer>> freStackMap = new HashMap<>();
        int maxFre = 0;
        public FreqStack() {

        }
        public void push(int val) {
            int frequency = valueFreMap.getOrDefault(val, 0) + 1;
            maxFre = Math.max(maxFre, frequency);
            valueFreMap.put(val, frequency);
            Stack<Integer> freStack = freStackMap.getOrDefault(frequency, new Stack<>());
            freStack.add(val);
            freStackMap.put(frequency, freStack);

        }
        public int pop() {
            Stack<Integer> freStack = freStackMap.get(maxFre);
            int value = freStack.pop();
            if (freStack.isEmpty()){
                maxFre--;
            }
            int freValue = valueFreMap.get(value);
            valueFreMap.put(value, --freValue);
            return value;
        }
    }
}