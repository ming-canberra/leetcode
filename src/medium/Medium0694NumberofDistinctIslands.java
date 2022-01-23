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

    class Solution1 {
        public int numDistinctIslands(int[][] grid) {

            int[][] dirs = new int[][]{new int[]{-1, 0}, new int[]{1, 0}, new int[]{0, 1}, new int[]{0, -1} };

            Set<String> allIslands = new HashSet<>();

            int rLen = grid.length;
            int cLen = grid[0].length;

            boolean[][] visited = new boolean[rLen][cLen];

            for (int i = 0; i < rLen; i++){
                for (int j = 0; j < cLen; j++){
                    if (!visited[i][j] && grid[i][j] == 1){
                        Queue<int[]> queue = new LinkedList<>();

                        queue.add(new int[]{i, j});
                        List<int[]> curIslandPositionList = new ArrayList<>();
                        while(!queue.isEmpty()){

                            int[] top = queue.poll();

                            if (top[0] >= 0 && top[0] < rLen && top[1] >= 0 && top[1] < cLen){
                                if (!visited[top[0]][top[1]] && grid[top[0]][top[1]] == 1){
                                    visited[top[0]][top[1]] = true;

                                    curIslandPositionList.add(top);

                                    for (int k = 0; k < 4; k++){
                                        int newRIdx = top[0] + dirs[k][0];
                                        int newCIdx = top[1] + dirs[k][1];

                                        queue.add(new int[]{newRIdx, newCIdx});
                                    }
                                }
                            }

                        }


                        // convert what is in curIslandPositionList, and add them to the set
                        StringBuilder sb = new StringBuilder();
                        for (int[] pos : curIslandPositionList){
                            sb.append(pos[0] - i + "r");
                            sb.append(pos[1] - j + "c");
                        }
                        allIslands.add(sb.toString());
                    }
                }
            }

            return allIslands.size();
        }
    }
}