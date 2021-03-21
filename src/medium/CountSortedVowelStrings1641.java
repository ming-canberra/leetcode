package medium;

import java.util.Arrays;

public class CountSortedVowelStrings1641 {
    public static void main(String[] args) {
        CountSortedVowelStrings1641 thisClass = new CountSortedVowelStrings1641();
        int dfa = thisClass.countVowelStrings(123);
        System.out.println(dfa);
    }

    public int countVowelStrings(int n) {
        if (n == 1){
            return 5;
        }
        else{
            int [][] dp = new int[n + 1][5];
            dp[2][0] = 1; // 0 matching u
            dp[2][1] = 1;
            dp[2][2] = 1;
            dp[2][3] = 1;
            dp[2][4] = 1; // 4 matching a
            for (int i = 3; i < dp.length; i++){
                dp[i][0] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2] + dp[i-1][3] + dp[i-1][4];
                dp[i][1] = dp[i-1][1] + dp[i-1][2] + dp[i-1][3] + dp[i-1][4];
                dp[i][2] = dp[i-1][2] + dp[i-1][3] + dp[i-1][4];
                dp[i][3] = dp[i-1][3] + dp[i-1][4];
                dp[i][4] = dp[i-1][4];
            }
            return dp[n][0] * 1 + dp[n][1] * 2 + dp[n][2] * 3 + dp[n][3] * 4 + dp[n][4] * 5;

        }
    }
}