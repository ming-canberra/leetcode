package medium;

import java.util.*;

public class Medium1615MaximalNetworkRank {
    class Solution {
        public int maximalNetworkRank(int n, int[][] roads) {
            int max = 0;

            List<Set<Integer>> adjList = new ArrayList<>();

            for (int i = 0; i < n; i++){
                adjList.add(new HashSet<>());
            }

            for (int [] road : roads){
                int city1 = road[0];
                int city2 = road[1];
                adjList.get(city1).add(city2);
                adjList.get(city2).add(city1);
            }

            for (int i = 0; i < n; i++){
                for (int j = i + 1; j < n; j++){
                    int curNetworkRank = adjList.get(i).size() + adjList.get(j).size();
                    if (adjList.get(i).contains(j)){
                        curNetworkRank--;
                    }
                    max = Math.max(max, curNetworkRank);
                }
            }

            return max;
        }
    }
}