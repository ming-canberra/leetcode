package medium;

import java.util.*;

public class Medium1197MinimumKnightMoves {
    class Solution {

        boolean[][] visited = new boolean[306][306];
        int[][] dirs = new int[][]{ new int[]{2, 1}, new int[]{-2, 1}, new int[]{2, -1}, new int[]{-2, -1},
                new int[]{1, 2}, new int[]{-1, 2}, new int[]{1, -2}, new int[]{-1, -2} };
        public int minKnightMoves(int x, int y) {
            x = Math.abs(x) + 5;
            y = Math.abs(y) + 5;
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{5, 5});
            int steps = 0;
            while(!queue.isEmpty()){
                for (int size = queue.size(); size > 0; size--){
                    int[] top = queue.poll();
                    int rIdx = top[0];
                    int cIdx = top[1];
                    if (rIdx >= 0 && rIdx < 306 && cIdx >= 0 && cIdx < 306){
                        if(!visited[rIdx][cIdx]){
                            visited[rIdx][cIdx] = true;
                            if (rIdx == x && cIdx == y){
                                return steps;
                            }
                            for (int i = 0; i < 8; i++){
                                queue.add( new int[]{ rIdx + dirs[i][0], cIdx + dirs[i][1] } );
                            }
                        }
                    }
                }
                steps++;
            }
            return steps;
        }
    }
}