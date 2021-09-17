package medium;

import java.util.*;

public class Medium310MinimumHeightTrees {
    class Solution {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            if (n == 1){
                return Arrays.asList(new Integer[]{0});
            }
            if (n == 2){
                return Arrays.asList(new Integer[]{0, 1});
            }
            int[] deg = new int[n];
            int len = edges.length;
            Map<Integer, Set<Integer>> map = new HashMap();
            for (int i = 0; i < len; i++){
                deg[edges[i][0]]++;
                deg[edges[i][1]]++;
                map.putIfAbsent(edges[i][0], new HashSet<>());
                map.putIfAbsent(edges[i][1], new HashSet<>());
                map.get(edges[i][0]).add(edges[i][1]);
                map.get(edges[i][1]).add(edges[i][0]);
            }
            Set<Integer> result = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < n; i++){
                if (deg[i] == 1){
                    queue.add(i);
                }
                else{
                    result.add(i);
                }
            }
            while(result.size() != 1 && result.size() != 2){
                for (int i = queue.size(); i > 0; i--){
                    int top = queue.poll();
                    for (int deIndex : map.get(top)){
                        deg[deIndex]--;
                        if (deg[deIndex] == 1 && result.contains(deIndex)){
                            queue.add(deIndex);
                            result.remove(deIndex);
                        }
                    }
                }
            }
            return new ArrayList<>(result);
        }
    }
}