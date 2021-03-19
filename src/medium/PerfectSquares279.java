package medium;

public class PerfectSquares279 {
    public static void main(String[] args) {
        PerfectSquares279 thisClass = new PerfectSquares279();

        int res = thisClass.thisDoesNotWork(48);
        System.out.println(res);
    }



    public int thisDoesNotWork(int n) {
        int dp[];
        if (n == 1){
            return 1;
        }
        else if (n == 2){
            return 2;
        }
        else if (n == 3){
            return 3;
        }
        else if (n == 4){
            return 1;
        }
        else if (n == 5){
            return 2;
        }
        else if (n == 6){
            return 3;
        }
        else if (n == 7){
            return 4;
        }
        else if (n == 8){
            return 2;
        }
        else if (n == 9){
            return 1;
        }

        dp = new int[n+1];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 1;
        dp[5] = 2;
        dp[6] = 3;
        dp[7] = 4;
        dp[8] = 2;
        dp[9] = 1;

        for (int j = 10; j < dp.length; j++){
            int i = 1;
            while (i*i < j){
                i++;
            }
            if (i*i == j){
                dp[j] = 1;
            }
            else{
                dp[j] =Math.min(1 + dp[j - (i-3)*(i-3)],Math.min( 1 + dp[j - (i-1)*(i-1)], 1 + dp[j - (i-2)*(i-2)]));
            }
        }

        return dp[n];
    }



}