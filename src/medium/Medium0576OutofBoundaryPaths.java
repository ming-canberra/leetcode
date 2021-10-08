package medium;

public class Medium0576OutofBoundaryPaths {
    class Solution {
        private int[][] dirs = new int[][]{new int[]{-1, 0}, new int[]{1, 0}, new int[]{0, -1}, new int[]{0, 1}};
        public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
            if (maxMove == 0){
                return 0;
            }
            int[][][]dp = new int[maxMove + 1][m][n];
            for (int k = 1; k < maxMove + 1; k++){
                for (int i = 0; i < m; i++){
                    for (int j = 0; j < n; j++){
                        int sum = 0;
                        for (int[] dir : dirs){
                            int a = i + dir[0];
                            int b = j + dir[1];
                            if (a<0||a==m||b<0||b==n){
                                sum += 1;
                            }
                            else{
                                sum = (sum + dp[k-1][a][b]) % 1000000007;
                            }
                        }
                        dp[k][i][j] = sum;
                    }
                }
            }
            return dp[maxMove][startRow][startColumn];
        }
    }
}