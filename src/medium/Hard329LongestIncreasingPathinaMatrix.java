package medium;

import java.util.*;

public class Hard329LongestIncreasingPathinaMatrix {
    class Solution {
        int total;
        int result = 1;
        int[][]dirs = new int[][]{new int[]{-1, 0}, new int[]{1, 0}, new int[]{0, 1}, new int[]{0, -1}};
        public int longestIncreasingPath(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            total = m * n;
            int[][] dp = new int[m][n];
            while(total != 0){
                for (int i = 0; i < m; i++){
                    for (int j = 0; j < n; j++){
                        cal(i, j, matrix, dp);
                    }
                }
            }
            return result;
        }
        private void cal(int i, int j, int[][] matrix, int[][] dp){
            if (dp[i][j] == 0){
                // find neighbors greater than me, if none, dp[me] == 1
                // neighbors greater than me but dp not ZERO, dp[me] == max dp + 1
                int meValue = matrix[i][j];
                boolean neighborExistsAndGreaterThanMeFound = false;
                int maxDp = 0;
                boolean skip = false;
                for (int k = 0; k < dirs.length; k++){
                    int x = i + dirs[k][0];
                    int y = j + dirs[k][1];
                    if (checkNeighborExistsAndGreaterThanMe(x, y, matrix, meValue)){
                        neighborExistsAndGreaterThanMeFound = true;
                        if (dp[x][y] != 0){
                            maxDp = Math.max(maxDp, dp[x][y]);
                        }
                        else{
                            skip = true;
                        }
                    }
                }
                if (!neighborExistsAndGreaterThanMeFound){
                    dp[i][j] = 1;
                    total--;
                    return;
                }
                if (maxDp > 0 && !skip){
                    dp[i][j] = maxDp + 1;
                    result = Math.max(result, dp[i][j]);
                    total--;
                }
            }
        }
        private boolean checkNeighborExistsAndGreaterThanMe(int i, int j, int[][] matrix, int meValue){
            if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length){
                return matrix[i][j] > meValue;
            }
            return false;
        }
    }
}