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

    class FreqStack1 {
        Map<Integer, Integer> freqMap = new HashMap<>();
        Map<Integer, Stack<Integer>> freqStacks = new HashMap<>();
        int maxFreq = 0;
        public FreqStack1() {
        }
        public void push(int val) {
            int freq = freqMap.getOrDefault(val, 0) + 1;
            freqMap.put(val, freq);
            maxFreq = Math.max(maxFreq, freq);
            Stack<Integer> stack = freqStacks.getOrDefault(freq, new Stack<>());
            stack.add(val);
            freqStacks.put(freq, stack);
        }
        public int pop() {
            Stack<Integer> maxFreqStack = freqStacks.get(maxFreq);
            int top = maxFreqStack.pop();
            if (maxFreqStack.isEmpty()){
                maxFreq--;
            }
            freqMap.put(top, freqMap.get(top) - 1);
            return top;
        }
    }
}