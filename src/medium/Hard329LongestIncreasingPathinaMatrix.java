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

    class Solution1 {
        int[][] dp;//length of LIP ending at (i, j);
        int m;
        int n;
        int[][] dirs = new int[][]{new int[]{-1, 0}, new int[]{1, 0}, new int[]{0, 1}, new int[]{0, -1}};
        public int longestIncreasingPath(int[][] matrix) {
            m = matrix.length;
            n = matrix[0].length;
            dp = new int[m][n];
            int result = 1;
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    result = Math.max(result, dfs(i, j, matrix));
                }
            }
            return result;
        }
        private int dfs(int row, int col, int[][] matrix){
            if(dp[row][col] != 0){
                return dp[row][col];
            }
            // this one is the smallest among all neighbors, then dp[row][col] = 1;
            // base case
            boolean iAmTheSmallest = true;
            for (int i = 0; i < dirs.length; i++){
                int x = row + dirs[i][0];
                int y = col + dirs[i][1];
                if (x >= 0 && x < m && y >= 0 && y < n){
                    if (matrix[x][y] < matrix[row][col]){
                        iAmTheSmallest = false;
                        break;
                    }
                }
            }
            if (iAmTheSmallest){
                dp[row][col] = 1;
                return dp[row][col];
            }
            // find all dp[x][y] for neighbors smaller than me, Max(dp[x][y]) + 1
            int max = 1;
            for (int i = 0; i < dirs.length; i++){
                int x = row + dirs[i][0];
                int y = col + dirs[i][1];
                if (x >= 0 && x < m && y >= 0 && y < n){
                    if (matrix[x][y] < matrix[row][col]){
                        max = Math.max(max, dfs(x, y, matrix));
                    }
                }
            }
            dp[row][col] = max + 1;
            return dp[row][col];
        }
    }
}