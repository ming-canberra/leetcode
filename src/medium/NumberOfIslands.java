package medium;

public class NumberOfIslands {
    public static void main(String[] args) {
        NumberOfIslands thisClass = new NumberOfIslands();
        System.out.println (thisClass.numIslands(null));
    }

    private boolean[][] islandTraversed;
    private static final Character ISLAND = '1';
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        islandTraversed = new boolean[m][n];
        int result = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (foundNewIslandAndMarkAdjacentIslands(i, j, grid, m, n)){
                    result++;
                }
            }
        }
        return result;
    }

    private boolean foundNewIslandAndMarkAdjacentIslands(int rIndex, int cIndex, char[][]grid, int m, int n){
        if (rIndex >=0 && rIndex < m
        && cIndex >= 0 && cIndex <n
                && grid[rIndex][cIndex] == ISLAND
        && !islandTraversed[rIndex][cIndex]){
            islandTraversed[rIndex][cIndex] = true;
            // also mark the adjacent islands found
            foundNewIslandAndMarkAdjacentIslands(rIndex, cIndex + 1, grid, m, n);
            foundNewIslandAndMarkAdjacentIslands(rIndex, cIndex - 1, grid, m, n);
            foundNewIslandAndMarkAdjacentIslands(rIndex + 1, cIndex, grid, m, n);
            foundNewIslandAndMarkAdjacentIslands(rIndex - 1, cIndex, grid, m, n);
            return true;
        }
        return false;
    }


    class Solution {

        public int numIslands(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            boolean[][] visited = new boolean[m][n];
            int count = 0;
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    if (!visited[i][j] && grid[i][j] == '1'){
                        count++;
                        dfs(grid, visited, i, j, m, n);
                    }
                }
            }
            return count;
        }
        /**
         * mark all adjacent grid as visited. so that only unvisited 1 can be counted.
         */
        private void dfs(char[][]grid, boolean[][] visited, int i, int j, int m, int n){
            if (i >= 0 && i < m && j >= 0 && j < n && !visited[i][j]){
                visited[i][j] = true;
                if (grid[i][j] == '1'){
                    // is island
                    dfs(grid, visited, i + 1, j, m, n);
                    dfs(grid, visited, i - 1, j, m, n);
                    dfs(grid, visited, i, j + 1, m, n);
                    dfs(grid, visited, i, j - 1, m, n);
                }
            }
        }
    }

    class Solution1 {
        private boolean[][] visited;
        public int numIslands(char[][] grid) {
            int result = 0;
            int m = grid.length;
            int n = grid[0].length;
            visited = new boolean[m][n];
            //1 island
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    if(!visited[i][j] && grid[i][j] == '1'){
                        result++;
                        dfs(grid, i, j);
                    }
                }
            }
            return result;
        }
        private void dfs(char[][]grid, int row, int col){
            if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && !visited[row][col]){
                visited[row][col] = true;
                if(grid[row][col] == '1'){
                    dfs(grid, row + 1, col);
                    dfs(grid, row - 1, col);
                    dfs(grid, row, col + 1);
                    dfs(grid, row, col - 1);
                }
            }
        }
    }
}