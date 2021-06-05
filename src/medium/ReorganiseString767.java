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
}