package easy;

import java.util.*;

public class SlowestKey1629 {
    public static void main(String[] args) {
        SlowestKey1629 thisClass = new SlowestKey1629();
        System.out.println(thisClass.slowestKey(null, "3"));
    }

    public char slowestKey(int[] releaseTimes, String keysPressed) {

        char result = keysPressed.charAt(0);

        int duration = releaseTimes[0];

        for (int i = 1; i < releaseTimes.length; i++)
        {
            int tmpD = releaseTimes[i] - releaseTimes[i - 1];
            if (tmpD > duration){
                duration = tmpD;
                result = keysPressed.charAt(i);
            }
            else if (tmpD == duration)
            {
                if (keysPressed.charAt(i) > result)
                {
                    result = keysPressed.charAt(i);
                }
            }
        }

        return result;
    }

    class Solution {
        public char slowestKey(int[] releaseTimes, String keysPressed) {
            int[] count = new int[26];
            for (int i = 0; i < releaseTimes.length; i++){
                int index = keysPressed.charAt(i) - 'a';
                if (i == 0){
                    count[index] = releaseTimes[0];
                }
                else{
                    count[index] = Math.max(count[index], releaseTimes[i] - releaseTimes[i - 1]);
                }
            }
            int resIndex = count.length - 1;
            for (int i = count.length - 1; i >= 0; i--){
                if (count[i] > count[resIndex])
                {
                    resIndex = i;
                }
            }
            return (char)('a' + resIndex);
        }
    }
}