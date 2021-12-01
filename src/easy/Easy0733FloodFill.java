package easy;

import java.util.*;

public class Easy0733FloodFill {
    class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            int m = image.length;
            int n = image[0].length;

            int[][] result = new int[m][n];

            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    result[i][j] = image[i][j];
                }
            }

            int oldColor = result[sr][sc];
            if (oldColor == newColor){
                return result;
            }

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{sr, sc});

            while(!queue.isEmpty()){
                int[] top = queue.poll();
                int rIdx = top[0];
                int cIdx = top[1];
                if (rIdx >= 0 && rIdx < m && cIdx >= 0 && cIdx < n ){
                    if (result[rIdx][cIdx] == oldColor){
                        result[rIdx][cIdx] = newColor;
                        queue.add(new int[]{rIdx + 1, cIdx});
                        queue.add(new int[]{rIdx - 1, cIdx});
                        queue.add(new int[]{rIdx, cIdx + 1});
                        queue.add(new int[]{rIdx, cIdx - 1});
                    }
                }
            }
            return result;
        }
    }
}