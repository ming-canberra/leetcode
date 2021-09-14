package medium;

import java.util.*;

public class ReorganiseString767 {

    /**
     * Referred to other's solution, spend like 50min for implementation.
     * Need to do it again.
     * Try NOT keeping track the char with highest count. Compare the top with the last char of result instead.
     * */
    class Solution {
        public String reorganizeString(String s) {
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++){
                Character c = s.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
                int count = map.get(c);
                if (count > (s.length() + 1) / 2){
                    return "";
                }
            }
            // max heap, sorting on count of characters
            PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>( (a, b)-> b[1] - a[1]);
            for (Character c : map.keySet()){
                maxHeap.add(new int[] {c, map.get(c)});
            }
            StringBuilder sb = new StringBuilder();
            int[] charMost = null;

            while(!maxHeap.isEmpty()){
                if (charMost == null)
                {
                    charMost = maxHeap.poll();
                    if (!maxHeap.isEmpty()){
                        int[] top = maxHeap.poll();
                        sb.append((char)(charMost[0]));
                        sb.append((char)(top[0]));
                        charMost[1]--;
                        top[1]--;
                        if (top[1] > 0){
                            maxHeap.add(top);
                        }
                        if (charMost[1] == 0){
                            charMost = null;
                        }
                    }
                    else{
                        sb.append((char)(charMost[0]));
                        charMost[1]--;
                    }
                }
                else{
                    if (!maxHeap.isEmpty()){
                        int[] top = maxHeap.poll();
                        sb.append((char)(charMost[0]));
                        sb.append((char)(top[0]));
                        charMost[1]--;
                        top[1]--;

                        if (charMost[1] < top[1]){
                            if (top[1] > 0){
                                maxHeap.add(top);
                            }
                            if (charMost[1] > 0){
                                maxHeap.add(charMost);
                            }
                            charMost = null;
                        }
                        else{
                            if (top[1] > 0){
                                maxHeap.add(top);
                            }
                            if (charMost[1] == 0){
                                charMost = null;
                            }
                        }
                    }
                    else{
                        sb.append((char)(charMost[0]));
                        charMost[1]--;
                    }
                }
            }

            if (charMost != null && charMost[1] > 0){
                sb.append((char)(charMost[0]));
            }

            return sb.toString();
        }
    }

    class Solution1 {
        public String reorganizeString(String s) {
            Map<Character, Integer> map = new HashMap<>();
            PriorityQueue<Pair> heap = new PriorityQueue<Pair>( (a, b)-> a.count == b.count ? b.key - a.key : b.count - a.count  );
            for (char cc : s.toCharArray()){
                map.put(cc,  map.getOrDefault(cc, 0) + 1 );
            }
            for (Character key : map.keySet()){
                heap.add(new Pair(key, map.get(key)));
            }
            int len = s.length();
            int charMaxLen = heap.peek().count;
            if (charMaxLen -1 <= len - charMaxLen)
            {
                StringBuilder sb = new StringBuilder();
                while(heap.size() > 0){
                    Pair maxPair = heap.poll();
                    sb.append(maxPair.key);
                    maxPair.count--;
                    if (heap.size() > 0){
                        Pair secondPair = heap.poll();
                        sb.append(secondPair.key);
                        secondPair.count--;
                        if (secondPair.count > 0){
                            heap.add(secondPair);
                        }
                    }
                    if (maxPair.count > 0){
                        heap.add(maxPair);
                    }
                }
                return sb.toString();
            }
            else{
                return "";
            }
        }
        class Pair{
            Character key;
            Integer count;
            public Pair(Character k, Integer c){
                key = k;
                count = c;
            }
        }
    }
}