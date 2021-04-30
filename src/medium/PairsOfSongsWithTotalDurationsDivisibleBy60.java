package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairsOfSongsWithTotalDurationsDivisibleBy60 {
    public static void main(String[] args) {
        PairsOfSongsWithTotalDurationsDivisibleBy60 thisClass = new PairsOfSongsWithTotalDurationsDivisibleBy60();
        System.out.println (thisClass.numPairsDivisibleBy60(null));
    }

    public int numPairsDivisibleBy60(int[] time) {
        int n = time.length;
        int count = 0;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++)
        {
            map.put(time[i], map.getOrDefault(time[i], 0) + 1);
        }

        for (int value : time)
        {
            for (int i = 1; i <= 16; i++)
            {
                if (map.containsKey(60 * i - value))
                {
                    int matchedValue = map.get(60 * i - value);
                    if (60 * i - value == value)
                    {
                        count+=(matchedValue - 1);
                    }
                    else
                    {
                        count+=matchedValue;
                    }
                }
            }
            int countInMap = map.get(value);
            if (countInMap == 1){
                map.remove(value);
            }
            else
            {
                map.put(value, countInMap - 1);
            }
        }

        return count;
    }
}