package medium;

import java.util.*;

public class Medium0261GraphValidTree {
    class Solution {
        public boolean validTree(int n, int[][] edges) {
            int len = edges.length;
            if (n != len + 1){
                return false;
            }

            boolean[][] connected = new boolean[n][n];

            for (int[] edge : edges){
                connected[edge[0]][edge[1]] = true;
                connected[edge[1]][edge[0]] = true;
            }

            Set<Integer> visited = new HashSet<>();

            Queue<Integer> queue = new LinkedList<>();
            queue.add(0);

            while(!queue.isEmpty()){

                int top = queue.poll();
                if (!visited.contains(top)){
                    for (int i = 0; i < n; i++){
                        if (i != top){

                            if (connected[top][i]){
                                queue.add(i);
                            }
                        }
                    }
                    visited.add(top);
                }

            }
            return visited.size() == n;
        }
    }
}