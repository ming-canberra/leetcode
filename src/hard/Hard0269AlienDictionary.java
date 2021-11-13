package hard;

import java.util.*;

public class Hard0269AlienDictionary {
    class Solution {
        public String alienOrder(String[] words) {
            Map<Character, Integer> charInDegrees = new HashMap<>();
            for (String word : words){
                for (char cc : word.toCharArray()){
                    charInDegrees.put(cc, 0);
                }
            }
            Map<Character, Set<Character>> map = new HashMap<>();
            Set<String> seen = new HashSet<>();
            for (int i = 1; i < words.length; i++){
                String firstS = words[i - 1];
                String secondS = words[i];
                int idx = 0;
                while(idx < firstS.length() && idx < secondS.length() && firstS.charAt(idx) == secondS.charAt(idx)){
                    idx++;
                }
                if (idx < firstS.length() && idx < secondS.length()){
                    String seenString = new String(new char[]{firstS.charAt(idx), secondS.charAt(idx)});

                    if (!seen.contains(seenString)){
                        seen.add(seenString);
                        charInDegrees.put(secondS.charAt(idx), charInDegrees.get(secondS.charAt(idx)) + 1);
                        Set<Character> toTakeList = map.getOrDefault(firstS.charAt(idx), new HashSet<>());
                        toTakeList.add(secondS.charAt(idx));
                        map.put(firstS.charAt(idx), toTakeList);
                    }
                }
                else{
                    if (firstS.length() > secondS.length()){
                        return "";
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            Queue<Character> queue = new LinkedList<>();
            for (Character key : charInDegrees.keySet()){
                if (charInDegrees.get(key) == 0){
                    queue.add(key);
                    sb.append(key);
                }
            }
            while(!queue.isEmpty()){
                for (int size = queue.size(); size > 0; size--){
                    Character top = queue.poll();
                    if (map.containsKey(top)){
                        Set<Character> toTakeList = map.get(top);
                        for (Character key : toTakeList){
                            int newCount = charInDegrees.get(key) - 1;
                            charInDegrees.put(key, newCount);
                            if (newCount == 0){
                                queue.add(key);
                                sb.append(key);
                            }
                        }
                    }
                }
            }
            if (sb.length() == charInDegrees.size()){
                return sb.toString();
            }
            else{
                return "";
            }
        }
    }
}