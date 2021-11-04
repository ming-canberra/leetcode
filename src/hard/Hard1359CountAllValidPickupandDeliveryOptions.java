package hard;

import java.util.*;

public class Hard1359CountAllValidPickupandDeliveryOptions {
    class Solution {
        public int countOrders(int n) {
            int mod = 1000000007;
            int[] dp = new int[n + 1];
            dp[1] = 1;
            for (int i = 2; i < n + 1; i++){
                int tmp = i * 2 - 1;
                long total = (long)dp[i - 1] * tmp * (tmp + 1) / 2;
                dp[i] = (int)(total % mod);
            }
            return dp[n];
        }
    }
}