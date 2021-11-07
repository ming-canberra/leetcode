package hard;

import java.util.*;

public class Hard0854KSimilarStrings {
    class Solution {
        public int kSimilarity(String s1, String s2) {
            if (s1.equals(s2)){
                return 0;
            }
            Queue<String> queue = new LinkedList<>();
            Set<String> seen = new HashSet<>();
            queue.add(s1);
            seen.add(s1);
            int steps = 0;
            while(!queue.isEmpty()){
                for (int size = queue.size(); size > 0; size--){
                    int index = 0;
                    String top = queue.poll();
                    while(index < top.length() && top.charAt(index) == s2.charAt(index)){
                        index++;
                    }
                    if (index == top.length()){
                        return steps;
                    }
                    for (int i = index + 1; i < top.length(); i++){
                        if (s2.charAt(i) == top.charAt(i)){
                            continue;
                        }
                        if (s2.charAt(i) == top.charAt(index)){
                            String newString = swap(top, i, index);
                            if (!seen.contains(newString)){
                                seen.add(newString);
                                queue.add(newString);
                            }
                        }
                    }
                }
                steps++;
            }
            return steps;
        }
        private String swap(String s, int a, int b){
            char[] chars = s.toCharArray();
            char tmp = chars[a];
            chars[a] = chars[b];
            chars[b] = tmp;

            return new String(chars);
        }
    }
}