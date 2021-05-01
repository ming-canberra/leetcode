package medium;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
        TopKFrequentWords thisClass = new TopKFrequentWords();
        List<String>   a = thisClass.topKFrequent(null, 1);

        System.out.println(a);

    }
    /**
     time O(nlogn)
     space O(n)
     */
    public List<String> topKFrequent(String[] words, int k) {

        List<String> result = new ArrayList<String>();

        Map<String, Integer> map = new HashMap<String, Integer>();

        for (String s : words){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (String key : map.keySet())
        {
            result.add(key);
        }

        Collections.sort(result, (a, b)->  map.get(b) - map.get(a) == 0?a.compareTo(b):map.get(b) - map.get(a));

        return result.subList(0, k);
    }
}