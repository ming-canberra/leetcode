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

    /**
    * O(N)
    * */
    class Solution2 {
        public int jump(int[] nums) {
            int count = 0;
            int index = 0;
            int n = nums.length;
            if (n == 1){
                return 0;
            }
            while(true){
                if (index >= n || index + nums[index] >= n -1){
                    return count + 1;
                }
                int max = 0;
                int iMax = 0;
                for (int i = 1; i <= nums[index]; i++){
                    if (i + nums[index + i] > max){
                        max = i + nums[index + i];
                        iMax = i;
                    }
                }
                count++;
                index = index + iMax;
            }
        }
    }
}