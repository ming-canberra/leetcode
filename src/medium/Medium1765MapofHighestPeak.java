package medium;

import java.util.*;

public class Medium1765MapofHighestPeak {
    class Solution {
        public int[][] highestPeak(int[][] isWater) {
            // 0 for land     1 for water
            int m = isWater.length;
            int n = isWater[0].length;
            int[][] height = new int[m][n];
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    height[i][j] = -1;
                }
            }
            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    if (isWater[i][j] == 1){
                        queue.add(new int[]{i, j});
                    }
                }
            }
            int level = 0;
            while(!queue.isEmpty()){
                for (int size = queue.size(); size > 0; size--){
                    int[] top = queue.poll();
                    int rIdx = top[0];
                    int cIdx = top[1];
                    if (top[0] >= 0 && top[0] < m && top[1] >= 0 && top[1] < n){
                        if (height[rIdx][cIdx] == -1){
                            height[rIdx][cIdx] = level;
                            queue.add(new int[]{rIdx + 1, cIdx});
                            queue.add(new int[]{rIdx - 1, cIdx});
                            queue.add(new int[]{rIdx, cIdx + 1});
                            queue.add(new int[]{rIdx, cIdx - 1});
                        }
                    }
                }
                level++;
            }
            return height;
        }
    }

}