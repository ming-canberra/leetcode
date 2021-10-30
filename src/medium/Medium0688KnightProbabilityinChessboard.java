package medium;

public class Medium0688KnightProbabilityinChessboard {
    class Solution {
        private int[][] dirs = new int[][]{new int[]{-1, -2}, new int[]{-1, 2}, new int[]{-2, -1}, new int[]{-2, 1},
                new int[]{1, -2}, new int[]{1, 2}, new int[]{2, -1}, new int[]{2, 1}};
        private double outBound = 0.0;

        private double[][][] memo;

        public double knightProbability(int n, int k, int row, int column) {

            memo = new double[n][n][k + 1];

            dfs(n, k, row, column);
            return (Math.pow(8, k) - outBound) / Math.pow(8, k);
        }
        private double dfs(int n, int k, int row, int column){
            if (row < 0 || column < 0 || row >= n || column >= n){
                outBound += Math.pow(8, k);
                return Math.pow(8, k);
            }
            if (k == 0){
                return 0.0;
            }

            if (memo[row][column][k] != 0.0){
                outBound += memo[row][column][k];
                return memo[row][column][k];
            }

            double sum = 0.0;
            for (int[] dir : dirs){
                int x = row + dir[0];
                int y = column + dir[1];
                sum += dfs(n, k - 1, x, y);
            }
            memo[row][column][k] = sum;
            return sum;
        }
    }

    class Solution1 {
        int[][] dirs = new int[][]{new int[]{2, 1}, new int[]{2, -1}, new int[]{-2, 1}, new int[]{-2, -1},
                new int[]{1, 2}, new int[]{1, -2}, new int[]{-1, 2}, new int[]{-1, -2}};
        double[][][] memo;  // the probability of out of boundary
        public double knightProbability(int n, int k, int row, int column) {
            memo = new double[n][n][k + 1];
            return 1.0 - backtrack(n, k, row, column, 1.0);
        }
        private double backtrack(int n, int k, int row, int col, double curP){
            if (row < 0 || col < 0 || row >= n || col >= n){
                return curP;
            }
            if (k == 0){
                return 0.0;
            }
            if (memo[row][col][k] != 0.0){
                return memo[row][col][k];
            }
            double sum = 0.0;
            for (int i = 0; i < dirs.length; i++){
                int x = row + dirs[i][0];
                int y = col + dirs[i][1];
                sum += backtrack(n, k - 1, x, y, curP * 0.125);
            }
            memo[row][col][k] = sum;
            return memo[row][col][k];
        }
    }
}