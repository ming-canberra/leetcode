package medium;

import java.util.*;

public class Medium0433MinimumGeneticMutation {
    class Solution {
        public int minMutation(String start, String end, String[] bank) {
            Set<String> bankSet = new HashSet<>( Arrays.asList(bank) );
            Set<String> visited = new HashSet<>();
            Queue<String> queue = new LinkedList<>();
            queue.add(start);
            int mutation = 0;
            while(!queue.isEmpty()){
                for (int size = queue.size(); size > 0; size--){
                    String top = queue.poll();
                    if (!visited.contains(top)){
                        visited.add(top);
                        if (top.equals(end)){
                            return mutation;
                        }
                        for (String sInBank : bankSet){
                            if (mutationAllowed(top, sInBank)){
                                queue.add(sInBank);
                            }
                        }
                    }
                }
                mutation++;
            }
            return -1;
        }
        private boolean mutationAllowed(String from, String to){
            int diffCount = 0;
            for (int i = 0; i < to.length(); i++){
                if (from.charAt(i) != to.charAt(i)){
                    diffCount++;
                }
            }
            return diffCount == 1;
        }
    }
}