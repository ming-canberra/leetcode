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

    class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            //low heap and high alphabetical
            PriorityQueue<Pair> min = new PriorityQueue<Pair>(new MyCom());
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < words.length; i++){
                map.put (words[i], map.getOrDefault(words[i], 0) + 1);
            }
            for (String key : map.keySet()){
                min.add(new Pair(key, map.get(key)));
                if (min.size() > k){
                    min.poll();
                }
            }
            List<String> result = new ArrayList<>();
            for (int i = 0; i < k; i++){
                result.add("");
            }
            for (int i = k - 1; i >= 0; i--){
                result.set(i, min.poll().word);
            }
            return result;
        }
        class Pair{
            int frequency;
            String word;
            Pair(String w, int f){
                frequency = f;
                word = w;
            }
        }
        class MyCom implements Comparator<Pair>{
            @Override
            public int compare(Pair a, Pair b){
                if (a.frequency == b.frequency){
                    return b.word.compareTo(a.word);
                }
                return a.frequency - b.frequency;
            }
        }
    }
}