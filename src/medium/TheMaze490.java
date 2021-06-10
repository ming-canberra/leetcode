package medium;

public class TheMaze490 {
    /**
     * seriously overtime, worked it out in 1.5 hours
     * */
    class Solution {
        public boolean hasPath(int[][] maze, int[] start, int[] destination) {
            int m = maze.length;
            int n = maze[0].length;
            boolean[][] visited = new boolean[m][n];
            return dfs(maze, start, destination, m, n, visited);
        }

        boolean dfs(int[][] maze, int[] start, int[] destination, int m, int n, boolean[][] visited) {
            int rIndex = start[0];
            int cIndex = start[1];
            if (rIndex >= 0 && rIndex < m && cIndex >= 0 && cIndex < n && !visited[rIndex][cIndex]){
                visited[rIndex][cIndex] = true;
                if (destination[0] == rIndex && destination[1] == cIndex){
                    return true;
                }
                // go left
                rIndex = start[0];
                cIndex = start[1];
                while (cIndex != -1 && maze[rIndex][cIndex] != 1){
                    cIndex--;
                }
                boolean hasPathLeft = dfs(maze, new int[]{rIndex, cIndex + 1}, destination, m, n, visited);
                // go right
                rIndex = start[0];
                cIndex = start[1];
                while (cIndex != n && maze[rIndex][cIndex] != 1){
                    cIndex++;
                }
                boolean hasPathRight = dfs(maze, new int[]{rIndex, cIndex - 1}, destination, m, n, visited);

                // go up
                rIndex = start[0];
                cIndex = start[1];
                while (rIndex != -1 && maze[rIndex][cIndex] != 1){
                    rIndex--;
                }
                boolean hasPathUp = dfs(maze, new int[]{rIndex + 1, cIndex}, destination, m, n, visited);

                // go down
                rIndex = start[0];
                cIndex = start[1];
                while (rIndex != m && maze[rIndex][cIndex] != 1){
                    rIndex++;
                }
                boolean hasPathDown = dfs(maze, new int[]{rIndex - 1, cIndex}, destination, m, n, visited);

                return hasPathLeft || hasPathRight || hasPathUp || hasPathDown;
            }

            return false;
        }
    }
}