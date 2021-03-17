package medium;

public class MinimumPathSum64 {
    public static void main(String[] args) {
        MinimumPathSum64 thisClass = new MinimumPathSum64();

        int res = thisClass.minPathSum(new int[][]{new int[]{1,2,3}, new int[]{4,5,6}});
        System.out.println(res);
    }
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length;i++){
            for (int j = 0; j < grid[0].length;j++){
                if (i >0 && j > 0){
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]);
                }
                else if (i == 0 && j == 0){

                }
                else if (i ==0){
                    dp[i][j] = dp[i][j-1];
                }
                else if (j == 0){
                    dp[i][j] = dp[i-1][j];
                }

                dp[i][j] +=grid[i][j];
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }
}