package medium;

import java.util.HashMap;
import java.util.Map;

public class Medium0621TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0){
            return tasks.length;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int maxCount = 0;
        for (int i : map.values()){
            maxCount = Math.max(maxCount, i);
        }
        int numCharsMaxCount = 0;
        for (int i : map.values()){
            if (i == maxCount){
                numCharsMaxCount++;
            }
        }
        if (maxCount * (n + 1) > tasks.length){
            if (numCharsMaxCount == 1){
                return Math.max(tasks.length, (maxCount - 1) * (n + 1) + 1);
            }
            else{
                if (n <= numCharsMaxCount - 1)
                {
                    return tasks.length;
                }
                else{
                    return Math.max((maxCount - 1) * (n + 1) + numCharsMaxCount, tasks.length);
                }
            }
        }
        else {
            return tasks.length;
        }
    }

    class Solution {
        public int leastInterval(char[] tasks, int n) {
            Map<Character, Integer> charCounts = new HashMap<>();
            int numMaxCount = 0;
            int maxCount = 0;
            for (char aChar : tasks) {
                int count = charCounts.getOrDefault(aChar, 0) + 1;
                charCounts.put(aChar, count);

                if (count > maxCount) {
                    maxCount = count;
                    numMaxCount = 1;
                }
                else if (count == maxCount) {
                    numMaxCount++;
                }
            }
            int res = (maxCount - 1) * (n + 1) + numMaxCount;
            return Math.max(res, tasks.length);
        }
    }
}