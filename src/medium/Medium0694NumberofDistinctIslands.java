package medium;

import java.util.*;

public class Medium0694NumberofDistinctIslands {
    class Solution {
        public int numDistinctIslands(int[][] grid) {
            // 1 for island
            int m = grid.length;
            int n = grid[0].length;
            Set<String> uniqueIsland = new HashSet<>();
            boolean[][] visited = new boolean[m][n];
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    if (!visited[i][j] && grid[i][j] == 1){
                        // found an island
                        List<int[]> gridsList = new ArrayList<>();
                        Queue<int[]> queue = new LinkedList<>();
                        queue.add(new int[]{i, j});
                        while(!queue.isEmpty()){
                            int[] top = queue.poll();
                            int rIdx = top[0];
                            int cIdx = top[1];
                            if (rIdx >= 0 && rIdx < m && cIdx >= 0 && cIdx < n){
                                if (!visited[rIdx][cIdx] ){
                                    visited[rIdx][cIdx] = true;
                                    if (grid[rIdx][cIdx] == 1){
                                        gridsList.add(new int[]{rIdx, cIdx} );
                                        queue.add(new int[]{rIdx + 1, cIdx});
                                        queue.add(new int[]{rIdx - 1, cIdx});
                                        queue.add(new int[]{rIdx, cIdx + 1});
                                        queue.add(new int[]{rIdx, cIdx - 1});
                                    }
                                }
                            }
                        }
                        String hashedIslandString = "";
                        for (int[] mygrid : gridsList){
                            mygrid[0] = mygrid[0] - i;
                            mygrid[1] = mygrid[1] - j;
                            hashedIslandString = hashedIslandString + mygrid[0] + "row" + mygrid[1] + "col";
                        }
                        uniqueIsland.add(hashedIslandString);
                    }
                }
            }
            return uniqueIsland.size();
        }
    }
}