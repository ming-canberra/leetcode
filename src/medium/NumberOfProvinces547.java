package medium;

import java.util.*;

public class NumberOfProvinces547 {
    public static void main(String[] args) {
        NumberOfProvinces547 thisClass = new NumberOfProvinces547();

    }

    public int findCircleNum(int[][] isConnected) {
        int length = isConnected.length;
        boolean[] visited = new boolean[length];
        int count = 0;
        for (int i = 0; i < length; i++){
            if (!visited[i]){
                dfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] graph, boolean[] visited, int i){

        visited[i] = true;

        for (int j = 0; j < visited.length; j++){
            if (graph[i][j] == 1)
            {
                if (!visited[j])
                {
                    dfs(graph, visited, j);
                }
            }
        }
    }

    class Solution {
        public int findCircleNum(int[][] isConnected) {
            int n = isConnected.length;
            int[] roots = new int[n];
            for (int i = 0; i < n; i++){
                roots[i] = i;
            }
            for (int i = 0; i < n - 1; i++){
                for (int j = i + 1; j < n; j ++){
                    // define i to be the root
                    if (isConnected[i][j] == 1){
                        int rootI = find(i, roots);
                        int rootJ = find(j, roots);
                        if (rootI != rootJ){
                            roots[rootJ] = rootI;
                        }
                    }
                }
            }
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++){
                set.add(find(i, roots));
            }
            return set.size();
        }
        private int find(int a, int[] roots){
            while (a != roots[a]){
                roots[a] = roots[roots[a]];
                a = roots[a];
            }
            return a;
        }
    }
}