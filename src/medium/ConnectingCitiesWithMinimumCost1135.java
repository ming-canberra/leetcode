package medium;

import java.util.*;

public class ConnectingCitiesWithMinimumCost1135 {
    /**
     *O(N + E*log(E) + E*log(N)) E is the number of connections
     * */
    class Solution {
        int count = 0;// n - 1 is the ending condition
        int result = 0;
        public int minimumCost(int n, int[][] connections) {
            Arrays.sort(connections, (a, b)-> a[2] -b[2]);
            int[] roots = new int[n + 1];
            for (int i = 0; i < roots.length; i++){
                roots[i] = i;
            }
            for (int i = 0; i < connections.length; i++){
                int rootX = findRoot(connections[i][0], roots);
                int rootY = findRoot(connections[i][1], roots);
                // unite 2 trees/groups together by making one of the root node's parent to be the other root node.
                if (rootX != rootY){
                    roots[rootY] = rootX;
                    count++;
                    result += connections[i][2];
                }
                if (count == n -1){
                    return result;
                }
            }
            return -1;
        }
        private int findRoot(int x, int[] roots){
            while (x != roots[x]){
                //path compression
                roots[x] = roots[roots[x]];
                x = roots[x];
            }
            return x;
        }
    }
}