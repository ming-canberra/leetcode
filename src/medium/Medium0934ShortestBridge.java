package medium;

import java.util.*;

public class Medium0934ShortestBridge {
    class Solution {
        int m;
        int n;

        public int shortestBridge(int[][] grid) {

            m = grid.length;
            n = grid[0].length;
            int[][] copied = new int[m][n];
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    copied[i][j] = grid[i][j];
                }
            }
            // change 1 island to 2 island
            boolean marked = false;
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    if (copied[i][j] == 1){
                        markIsland2(copied, i, j);
                        marked = true;
                        break;
                    }
                }
                if (marked){
                    break;
                }
            }
            int shortest = Integer.MAX_VALUE;
            // from 1 island to 2 island
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    if (copied[i][j] == 1){
                        int stepsFound = searchShortest(copied, i, j, new boolean[m][n]);
                        if (stepsFound != -1){
                            shortest = Math.min(shortest, stepsFound);
                        }
                    }
                }
            }

            return shortest;
        }

        private int searchShortest(int[][] copied, int rIdx, int cIdx, boolean[][] visited){
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{rIdx + 1, cIdx});
            queue.add(new int[]{rIdx - 1, cIdx});
            queue.add(new int[]{rIdx, cIdx + 1});
            queue.add(new int[]{rIdx, cIdx - 1});

            int steps = 0;
            while(!queue.isEmpty()){

                for (int size = queue.size(); size > 0; size--){

                    int[] top = queue.poll();
                    if (top[0] >= 0 && top[0] < m && top[1] >= 0 && top[1] < n){
                        if (!visited[top[0]][top[1]]){
                            visited[top[0]][top[1]] = true;

                            if (copied[top[0]][top[1]] == 0){
                                queue.add(new int[]{top[0] + 1, top[1]});
                                queue.add(new int[]{top[0] - 1, top[1]});
                                queue.add(new int[]{top[0], top[1] + 1});
                                queue.add(new int[]{top[0], top[1] - 1});
                            }


                            if (copied[top[0]][top[1]] == 2){
                                // found it
                                return steps;
                            }

                        }
                    }
                }
                steps++;
            }
            return -1;
        }

        // change 1 island to 2 island
        private void markIsland2(int[][] copied, int rIdx, int cIdx){
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{rIdx, cIdx});
            while(!queue.isEmpty()){
                int[] top = queue.poll();
                if (top[0] >= 0 && top[0] < m && top[1] >= 0 && top[1] < n){
                    if (copied[top[0]][top[1]] == 1){
                        copied[top[0]][top[1]] = 2;

                        queue.add(new int[]{top[0] + 1, top[1] });
                        queue.add(new int[]{top[0] - 1, top[1] });
                        queue.add(new int[]{top[0], top[1] + 1});
                        queue.add(new int[]{top[0], top[1] - 1});
                    }
                }
            }
        }

    }
    class Solution1 {
        int m, n;
        public int shortestBridge(int[][] grid) {
            m = grid.length;
            n = grid[0].length;
            boolean marked = false;
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    if (grid[i][j] == 1){
                        markAsIslandTwo(grid, i, j);
                        marked = true;
                        break;
                    }
                }
                if (marked){
                    break;
                }
            }

            return fromTwoToOne(grid);
        }
        private int fromTwoToOne(int[][] grid){
            int steps = 0;
            boolean[][] visited = new boolean[m][n];
            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    if (grid[i][j] == 2){
                        queue.add(new int[]{i, j});
                    }
                }
            }
            while(!queue.isEmpty()){
                for (int size = queue.size(); size > 0; size--){
                    int[] top = queue.poll();

                    if (grid[top[0]][top[1]] == 1){
                        return steps - 1;
                    }
                    if (!visited[top[0]][top[1]]){
                        visited[top[0]][top[1]] = true;
                        for (int i = 0; i < dirs.length; i++){
                            int newX = top[0] + dirs[i][0];
                            int newY = top[1] + dirs[i][1];
                            if (newX >= 0 && newX < m && newY >= 0 && newY < n){
                                if (grid[newX][newY] != 2){
                                    queue.add(new int[]{newX, newY});
                                }
                            }
                        }
                    }
                }
                steps++;
            }
            return 1;
        }
        int[][] dirs = new int[][]{new int[]{-1, 0}, new int[]{1, 0}, new int[]{0, 1}, new int[]{0, -1}};
        private void markAsIslandTwo(int[][] grid, int rIdx, int cIdx){
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{rIdx, cIdx});
            while(!queue.isEmpty()){
                int[] top = queue.poll();
                if (top[0] >= 0 && top[0] < m && top[1] >= 0 && top[1] < n && grid[top[0]][top[1]] == 1){
                    grid[top[0]][top[1]] = 2;
                    for (int i = 0; i < dirs.length; i++){
                        int newX = top[0] + dirs[i][0];
                        int newY = top[1] + dirs[i][1];
                        queue.add(new int[]{newX, newY});
                    }
                }
            }
        }
    }
}