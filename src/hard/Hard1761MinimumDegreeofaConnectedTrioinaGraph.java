package hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Hard1761MinimumDegreeofaConnectedTrioinaGraph {
    class Solution {
        public int minTrioDegree(int n, int[][] edges) {
            int[] degrees = new int[n + 1]; // degrees for each vertex
            boolean[][] isEdge = new boolean[n + 1][n + 1];
            for (int[] edge : edges){
                isEdge[edge[0]][edge[1]] = true;
                isEdge[edge[1]][edge[0]] = true;
                degrees[edge[0]]++;
                degrees[edge[1]]++;
            }
            int minimum = Integer.MAX_VALUE;
            for (int[] edge : edges){
                int v1 = edge[0];
                int v2 = edge[1];
                for (int j = 1; j < n + 1; j++){
                    if (j != v1 && j != v2){
                        if (isEdge[v1][j] && isEdge[v2][j])
                        {
                            minimum = Math.min(minimum, degrees[j] + degrees[v1] + degrees[v2] - 6);
                        }
                    }
                }
            }
            return minimum == Integer.MAX_VALUE ? -1 : minimum;
        }
    }
}