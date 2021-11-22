package hard;

public class Hard1223DiceRollSimulation {

    class Solution {

        int[][][] memo = new int[5000][6][15];
        int mod = 1000000007;
        public int dieSimulator(int n, int[] rollMax) {
            int sum = 0;
            for (int i = 1; i <= 6; i++){
                sum = (sum + dfs(n - 1, i, rollMax, 1)) % mod;
            }
            return sum;
        }
        private int dfs(int n, int curDie, int[] rollMax, int consecutiveRun){
            if (n == 0){
                return 1;
            }

            if (memo[n - 1][curDie - 1][consecutiveRun - 1] > 0){
                return memo[n - 1][curDie - 1][consecutiveRun - 1];
            }

            int sum = 0;
            for (int i = 1; i <= 6; i++){
                if (curDie != i){
                    sum = (sum + dfs(n - 1, i, rollMax, 1)) % mod;
                }
            }

            if (consecutiveRun < rollMax[curDie - 1]){
                sum = (sum + dfs(n - 1, curDie, rollMax, consecutiveRun + 1)) % mod;
            }

            memo[n - 1][curDie - 1][consecutiveRun - 1] = sum;

            return sum;
        }
    }


}