package medium;

import java.util.*;

public class Medium0417PacificAtlanticWaterFlow {
    class Solution {
        int m;
        int n;
        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            m = heights.length;
            n = heights[0].length;
            boolean[][] pacRechable = new boolean[m][n];
            boolean[][] atlRechable = new boolean[m][n];
            for (int i = 0; i < m; i++){
                bfs(heights, i, 0, pacRechable);
                bfs(heights, i, n - 1, atlRechable);
            }
            for (int i = 0; i < n; i++){
                bfs(heights, 0, i, pacRechable);
                bfs(heights, m - 1, i, atlRechable);
            }
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    if (pacRechable[i][j] && atlRechable[i][j]){
                        result.add( Arrays.asList( new Integer[]{i, j}) );
                    }
                }
            }
            return result;
        }
        int[][] dirs = new int[][]{new int[]{1, 0}, new int[]{-1, 0}, new int[]{0, 1}, new int[]{0, -1}};
        private void bfs(int[][] heights, int rIdx, int cIdx, boolean[][] reachable){
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{rIdx, cIdx});
            while(!queue.isEmpty()){
                int[] top = queue.poll();
                if (!reachable[top[0]][top[1]]){
                    reachable[top[0]][top[1]] = true;
                    for (int i = 0; i < dirs.length; i++){
                        int newX = top[0] + dirs[i][0];
                        int newY = top[1] + dirs[i][1];
                        if (newX >= 0 && newX < m && newY >= 0 && newY < n){
                            if (heights[newX][newY] >= heights[top[0]][top[1]]){
                                queue.add(new int[]{newX, newY});
                            }
                        }
                    }
                }
            }
        }
    }

    class Solution2 {
        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            int rNum = heights.length;
            int cNum = heights[0].length;

            boolean[][] canGoToPacific = new boolean[rNum][cNum];
            boolean[][] canGoToAtlantic = new boolean[rNum][cNum];

            int[][] dirs = new int[][]{new int[]{-1, 0}, new int[]{1, 0}, new int[]{0, 1}, new int[]{0, -1}};

            for (int i = 0; i < rNum; i++){
                for (int j = 0; j < cNum; j++){
                    if(!canGoToPacific[i][j] && (i == 0 || j == 0)){

                        Queue<int[]> queue = new LinkedList<>();
                        queue.add(new int[]{i, j});
                        while(!queue.isEmpty()){
                            int[] top = queue.poll();

                            if (!canGoToPacific[top[0]][top[1]]){
                                canGoToPacific[top[0]][top[1]] = true;
                                for (int k = 0; k < 4; k++){
                                    int newR = top[0] + dirs[k][0];
                                    int newC = top[1] + dirs[k][1];
                                    if (newR >= 0 && newR < rNum && newC >= 0 && newC < cNum){
                                        if (heights[newR][newC] >= heights[top[0]][top[1]]){
                                            queue.add(new int[]{newR, newC});
                                        }
                                    }
                                }
                            }
                        }
                    }

                    if(!canGoToAtlantic[i][j] && (i == rNum - 1 || j == cNum - 1)){

                        Queue<int[]> queue = new LinkedList<>();
                        queue.add(new int[]{i, j});
                        while(!queue.isEmpty()){
                            int[] top = queue.poll();

                            if (!canGoToAtlantic[top[0]][top[1]]){
                                canGoToAtlantic[top[0]][top[1]] = true;
                                for (int k = 0; k < 4; k++){
                                    int newR = top[0] + dirs[k][0];
                                    int newC = top[1] + dirs[k][1];
                                    if (newR >= 0 && newR < rNum && newC >= 0 && newC < cNum){
                                        if (heights[newR][newC] >= heights[top[0]][top[1]]){
                                            queue.add(new int[]{newR, newC});
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            List<List<Integer>> result = new ArrayList<>();

            for (int i = 0; i < rNum; i++){
                for (int j = 0; j < cNum; j++){
                    if (canGoToPacific[i][j] && canGoToAtlantic[i][j]){
                        result.add(Arrays.asList(new Integer[]{i, j}));
                    }
                }
            }

            return result;
        }
    }
}