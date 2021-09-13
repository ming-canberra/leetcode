package medium;

import java.util.*;

public class Medium451SortCharactersByFrequency {
    class Solution {
        public String frequencySort(String s) {
            Map<Character, Integer> map = new HashMap<>();
            for (char cc : s.toCharArray()){
                map.put(cc, map.getOrDefault(cc, 0) + 1);
            }
            PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b)->b.frequency - a.frequency);
            for (Character cc : map.keySet()){
                maxHeap.add(new Pair(cc, map.get(cc) ) );
            }
            StringBuilder sb = new StringBuilder();
            while(!maxHeap.isEmpty()){
                Pair pair = maxHeap.poll();
                for (int i = 0; i < pair.frequency; i++){
                    sb.append(pair.key);
                }
            }
            return sb.toString();
        }
        class Pair{
            char key;
            int frequency;
            public Pair(char k, int f){
                key = k;
                frequency = f;
            }
        }
    }
}