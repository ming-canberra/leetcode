package medium;

import java.util.*;

public class Medium1319NumberofOperationstoMakeNetworkConnected {
    class Solution {
        public int makeConnected(int n, int[][] connections) {
            int numConnections = connections.length;
            if (numConnections < n - 1){
                return -1;
            }
            int[] parents = new int[n];
            Arrays.fill(parents, -1);
            for (int[] con : connections){
                int ancestor0 = findAncestor(parents, con[0]);
                int ancestor1 = findAncestor(parents, con[1]);
                // union
                if (ancestor0 != ancestor1){
                    parents[ancestor1] = ancestor0;
                }
            }
            int totalGroups = 0;
            for (int p : parents){
                if (p == -1){
                    totalGroups++;
                }
            }
            return totalGroups - 1;
        }
        private int findAncestor(int[] parents, int idx){
            while(parents[idx] != -1){
                if (parents[parents[idx]] != -1){
                    parents[idx] = parents[parents[idx]];
                }
                idx = parents[idx];
            }
            return idx;
        }
    }
}