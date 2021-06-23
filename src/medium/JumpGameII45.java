package medium;

import java.util.*;

public class JumpGameII45 {
    class Solution {
        public int jump(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            dp[0] = 0;

            for (int i = 1; i < n; i++){

                int min = n;
                for (int j = 0; j < i; j++){
                    if (j + nums[j] >= i){
                        min = Math.min(min, dp[j] + 1);
                    }
                }
                dp[i] = min;
            }

            return dp[n - 1];
        }
    }
}