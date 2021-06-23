package medium;

import java.util.*;

public class ShortestPathtoGetFood1730 {
    class Solution {
        public int getFood(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            boolean[][] visited = new boolean[m][n];
            int[] start = null;
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    if (grid[i][j] == '*'){
                        start = new int[]{i, j};
                        visited[i][j] = true;
                    }
                    else if (grid[i][j] == 'X'){
                        visited[i][j] = true;
                    }
                }
            }
            Queue<int[]> queue = new LinkedList<>();
            queue.add(start);
            int path = 0;
            while (!queue.isEmpty()){
                int size = queue.size();
                path++;
                for (int i = 0; i < size; i++){
                    int[] top = queue.poll();
                    int r = top[0];
                    int c = top[1];
                    if (foodFound(r, c + 1, queue, visited, grid, m, n)){
                        return path;
                    }
                    if (foodFound(r + 1, c, queue, visited, grid, m, n)){
                        return path;
                    }
                    if (foodFound(r - 1, c, queue, visited, grid, m, n)){
                        return path;
                    }
                    if (foodFound(r, c - 1, queue, visited, grid, m, n)){
                        return path;
                    }
                }
            }
            return -1;
        }
        private boolean foodFound(int r, int c, Queue<int[]> queue, boolean[][] visited, char[][] grid, int m, int n){
            if (r >= 0 && r < m && c >= 0 && c <n && !visited[r][c]){
                visited[r][c] = true;
                if(grid[r][c] == '#'){
                    return true;
                }
                else{
                    queue.add(new int[]{r, c});
                }
            }

            return false;
        }
    }
}