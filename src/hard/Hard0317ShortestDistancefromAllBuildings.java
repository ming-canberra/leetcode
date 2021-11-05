package hard;

import java.util.*;

public class Hard0317ShortestDistancefromAllBuildings {
    class Solution {
        int m;
        int n;
        public int shortestDistance(int[][] grid) {
            int result = Integer.MAX_VALUE;

            int numHouses = 0;
            m = grid.length;
            n = grid[0].length;

            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    if (grid[i][j] == 1){
                        numHouses++;
                    }
                }
            }

            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    if (grid[i][j] == 0){
                        int tmp = bfs(grid, i, j, numHouses);
                        if (tmp != -1){
                            result = Math.min(result, tmp);
                        }

                    }
                }
            }

            return result == Integer.MAX_VALUE ? -1 : result;
        }

        private int bfs(int[][] grid, int rIdx, int cIdx, int numHouses){
            Queue<int[]> queue = new LinkedList<>();
            queue.add( new int[]{rIdx, cIdx} );
            int step = 0;
            int hCount = 0;
            int result = 0;
            boolean[][] visited = new boolean[m][n];
            while(!queue.isEmpty() && hCount != numHouses){
                for (int size = queue.size(); size > 0; size--){
                    int[] top = queue.poll();

                    if (top[0] < 0 || top[1] < 0 || top[0] >= m || top[1] >= n){
                        continue;
                    }

                    if (visited[top[0]][top[1]]){
                        continue;
                    }

                    visited[top[0]][top[1]] = true;

                    if (grid[top[0]][top[1]] == 1){
                        hCount++;
                        result += step;
                    }
                    else if (grid[top[0]][top[1]] == 0){
                        // add neighbours
                        queue.add( new int[]{top[0] + 1, top[1]} );
                        queue.add( new int[]{top[0] - 1, top[1]} );
                        queue.add( new int[]{top[0], top[1] + 1} );
                        queue.add( new int[]{top[0], top[1] - 1} );

                    }

                    if (hCount == numHouses){
                        break;
                    }
                }

                step++;

            }

            if (hCount == numHouses){
                return result;
            }
            else{
                return -1;
            }
        }

    }
}