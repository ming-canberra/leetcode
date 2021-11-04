package medium;

import java.util.*;

public class Medium0286WallsandGates {

    class Solution {
        int INF = 2147483647;
        int[][] dirs = new int[][]{ new int[]{0, 1}, new int[]{1, 0}, new int[]{0, -1}, new int[]{-1, 0} };
        int m;
        int n;
        public void wallsAndGates(int[][] rooms) {
            m = rooms.length;
            n = rooms[0].length;
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    bfs(rooms, i, j);
                }
            }
        }
        private void bfs(int[][] rooms, int x, int y){
            if(rooms[x][y] == 0){
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{x, y});
                int curDis = 0;
                while(!queue.isEmpty()){
                    // layer by layer
                    for (int size = queue.size(); size > 0; size--){
                        int[] top = queue.poll();
                        int rIdx = top[0];
                        int cIdx = top[1];
                        if (rIdx < 0 || rIdx >= m || cIdx < 0 || cIdx >= n){
                            continue;
                        }

                        if (curDis == 0){
                            for (int i = 0; i < 4; i++){
                                queue.add(new int[]{rIdx + dirs[i][0], cIdx + dirs[i][1]});
                            }
                        }
                        else{

                            if (rooms[rIdx][cIdx] > curDis){
                                rooms[rIdx][cIdx] = curDis;
                                for (int i = 0; i < 4; i++){
                                    queue.add(new int[]{rIdx + dirs[i][0], cIdx + dirs[i][1]});
                                }
                            }

                        }
                    }
                    curDis++;
                }
            }
        }
    }
}