package medium;

import java.util.*;

public class Medium0542Matrix01 {
    class Solution {
        public int[][] updateMatrix(int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;
            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == 0) {
                        queue.add(new int[]{i + 1, j});
                        queue.add(new int[]{i - 1, j});
                        queue.add(new int[]{i, j + 1});
                        queue.add(new int[]{i, j - 1});
                    }
                    if (mat[i][j] == 1) {
                        mat[i][j] = Integer.MAX_VALUE;
                    }
                }
            }
            int curDis = 1;
            while(!queue.isEmpty()) {
                int size = queue.size();
                for (int k = 0; k < size; k++ ) {
                    int[] top = queue.remove();
                    if (top[0] >= 0 && top[0] < m && top[1] >= 0 && top[1] < n) {
                        if (mat[top[0]][top[1]] > curDis) {
                            mat[top[0]][top[1]] = curDis;
                            queue.add(new int[]{top[0] + 1, top[1]});
                            queue.add(new int[]{top[0] - 1, top[1]});
                            queue.add(new int[]{top[0], top[1] + 1});
                            queue.add(new int[]{top[0], top[1] - 1});
                        }
                    }
                }
                curDis++;
            }

            return mat;
        }
    }
}
