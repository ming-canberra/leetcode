package medium;

public class Medium1706WhereWillTheBallFall {
    class Solution {
        public int[] findBall(int[][] grid) {
            int rLen = grid.length;
            int cLen = grid[0].length;

            int[][] pos = new int[rLen][cLen]; // represents after each level, the ith ball's position

            for (int i = 0; i < rLen; i++) {
                for (int j = 0; j < cLen; j++) {
                    int init = i == 0 ? j : pos[i - 1][j];

                    if (init == -1) {
                        pos[i][j] = -1;
                    }
                    else {
                        if (grid[i][init] == 1) {
                            if (init + 1 == cLen)
                            {
                                pos[i][j] = -1;
                            }
                            else if (grid[i][init + 1 ] == 1) {
                                pos[i][j] = init + 1;
                            }
                            else {
                                pos[i][j] = -1;
                            }
                        }
                        else {
                            if (init - 1 == -1)
                            {
                                pos[i][j] = -1;
                            }
                            else if (grid[i][init - 1 ] == -1) {
                                pos[i][j] = init - 1;
                            }
                            else {
                                pos[i][j] = -1;
                            }
                        }
                    }
                }
            }

            return pos[rLen - 1];
        }
    }
}