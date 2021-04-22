package medium;

import java.util.HashMap;

public class TaskScheduler621 {
    public static void main(String[] args) {
        TaskScheduler621 thisClass = new TaskScheduler621();

        System.out.println (thisClass.leastInterval(new char[]{'A','B','C','D','A','B','V'}, 3));
    }
    public int leastInterval(char[] tasks, int n) {
        if (n == 0){
            return tasks.length;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
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
}