package medium;

import java.util.*;

public class Medium2039TheTimeWhentheNetworkBecomesIdle {

    class Solution {
        public int networkBecomesIdle(int[][] edges, int[] patience) {
            int n = patience.length;
            Map<Integer, Set<Integer> > adjMap = new HashMap<>();
            for (int[] ed : edges){
                int node1 = ed[0];
                int node2 = ed[1];

                Set<Integer> set = adjMap.getOrDefault(node1, new HashSet<>());
                set.add(node2);
                adjMap.put(node1, set);

                set = adjMap.getOrDefault(node2, new HashSet<>());
                set.add(node1);
                adjMap.put(node2, set);
            }

            Map<Integer, Integer> nodeDistanceMap = new HashMap<>();
            nodeDistanceMap.put(0, 0);
            Queue<Integer> queue = new LinkedList<>();
            queue.add(0);

            int distance = 0;

            while(nodeDistanceMap.size() != n){
                distance++;
                for (int size = queue.size(); size > 0 ; size--){
                    int top = queue.poll();
                    Set<Integer> neighborsSet = adjMap.get(top);
                    for (int neighborNode  : neighborsSet){
                        if (!nodeDistanceMap.containsKey(neighborNode)){
                            nodeDistanceMap.put(neighborNode, distance);
                            queue.add(neighborNode);
                        }
                    }
                }
            }

            int[] travelTimes = new int[n];
            for (int i = 1; i < n; i++){
                travelTimes[i] = nodeDistanceMap.get(i) * 2;
            }

            int maxResult = 0;

            for (int i = 1; i < n; i++){
                if (patience[i] < travelTimes[i]){
                    maxResult = Math.max(maxResult,  (travelTimes[i] - 1) / patience[i] * patience[i] + travelTimes[i]  );
                }
                else{
                    maxResult = Math.max(maxResult, travelTimes[i]);
                }
            }
            return maxResult + 1;
        }
    }
}