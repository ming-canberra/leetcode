package medium;

import java.util.Arrays;

public class NumberOfConnectedComponentsInAnUndirectedGraph323 {
    public static void main(String[] args) {
        NumberOfConnectedComponentsInAnUndirectedGraph323 thisClass = new NumberOfConnectedComponentsInAnUndirectedGraph323();

    }
    public int countComponents(int n, int[][] edges) {
        // the test case [[1,0],[2,0]] breaks the problem description
        for (int i = 0; i < edges.length; i++){
            if (edges[i][0] > edges[i][1] )
            {
                int tmp = edges[i][0];
                edges[i][0] = edges[i][1];
                edges[i][1] = tmp;
            }
        }

        Arrays.sort(edges, (a, b)-> a[0] - b[0]);

        boolean[] visitedN = new boolean[n];
        boolean[] visitedE = new boolean[edges.length];

        int count = 0;
        for (int i = 0; i < edges.length; i++){
            if (!visitedE[i]){

                dfs(visitedN, visitedE, edges, i);

                count++;
            }
        }
        System.out.println(count);
        for (int i = 0; i < visitedN.length; i++){
            if (!visitedN[i]){
                count++;
            }
        }

        return count;
    }


    private void dfs(boolean[] visitedN, boolean[] visitedE, int[][] edges, int eIndex)
    {
        visitedE[eIndex] = true;
        int a = edges[eIndex][0];
        int b = edges[eIndex][1];
        visitedN[a] = true;
        visitedN[b] = true;

        // get all edges starting with a; for each a, call dfs
        dfsOnNode(visitedN, visitedE, edges, eIndex, a);

        dfsOnNode(visitedN, visitedE, edges, eIndex, b);
    }

    private void dfsOnNode(boolean[] visitedN, boolean[] visitedE, int[][] edges, int eIndex, int nodeValue)
    {
        // this needs to be optimised
        for (int i = 0; i < edges.length; i++){
            if (edges[i][0] > nodeValue){
                break;
            }
            if ((edges[i][0] == nodeValue || edges[i][1] == nodeValue) && !visitedE[i]){
                dfs(visitedN, visitedE, edges, i);
            }
        }
    }

    /**
     * union-find
     *
     * O(N + E*log(N))
     *
     * */
    class Solution {
        public int countComponents(int n, int[][] edges) {
            int count = n;
            int[] roots = new int[n];
            for (int i = 0; i < roots.length; i++){
                roots[i] = i;
            }
            for (int i = 0; i < edges.length; i++){
                int rootX = findRoot(edges[i][0], roots);
                int rootY = findRoot(edges[i][1], roots);
                // union,
                if (rootX != rootY){
                    roots[rootY] = rootX;
                    count--;
                }
            }
            return count;
        }
        private int findRoot(int x, int[] roots){
            while( x != roots[x]){
                // path compression
                roots[x] = roots[roots[x]];
                x = roots[x];
            }
            return x;
        }
    }
}