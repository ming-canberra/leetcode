package medium;

public class IntegerBreak343 {
    public static void main(String[] args) {
        IntegerBreak343 thisClass = new IntegerBreak343();

        int res = thisClass.integerBreak(10);
        System.out.println(res);
    }
    public int integerBreak2(int n) {
        if (n==2){
            return 1;
        }
        else if (n==3){
            return 2;
        }
        else if (n == 4){
            return 4;
        }
        else if (n == 5){
            return 6;
        }
        else if (n == 6){
            return 9;
        }

        return Math.max(2 * integerBreak2(n-2), 3* integerBreak2(n-3));
    }


    public int integerBreak(int n) {
        if (n==2){
            return 1;
        }
        else if (n==3){
            return 2;
        }
        else if (n == 4){
            return 4;
        }
        else if (n == 5){
            return 6;
        }
        else if (n == 6){
            return 9;
        }
        else if (n == 7){
            return 12;
        }
        int dp[] = new int[n-1];
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 4;
        dp[5] = 6;
        dp[6] = 9;
        for (int i = 7; i < n-1; i++){
            dp[i] = Math.max(2 * dp[i-2], 3 * dp[i-3]);
        }

        return Math.max(2 * dp[n-2], 3 * dp[n-3]);
    }
}