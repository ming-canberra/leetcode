package medium;

import java.util.*;

public class HouseRobberII213 {
    public int rob(int[] nums) {
        int [] helperArray;

        if (nums.length ==1){
            return nums[0];
        }
        else{
            // robbing first one
            helperArray = new int[nums.length];
            helperArray[0] = nums[0];
            for (int i = 1;i< nums.length;i++){
                if (i == 1){
                    helperArray[1] = nums[0];
                }
                else if (i == nums.length -1){
                    helperArray[i] = Math.max(helperArray[i-2], helperArray[i-1]);
                }
                else{
                    helperArray[i] = Math.max(helperArray[i-2] + nums[i], helperArray[i-1]);
                }
            }
            int tempResult1 = helperArray[nums.length -1];

            //NOT robbing first one
            helperArray = new int[nums.length];
            helperArray[0] = 0;
            for (int i = 1;i< nums.length;i++){
                if (i == 1){
                    helperArray[1] = nums[1];
                }
                else{
                    helperArray[i] = Math.max(helperArray[i-2] + nums[i], helperArray[i-1]);
                }
            }
            int tempResult2 = helperArray[nums.length -1];
            return Math.max(tempResult2, tempResult1);
        }
    }

    class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            if (n == 1){
                return nums[0];
            }
            int[] dp = new int[n];
            dp[0] = nums[0];
            for (int i = 1; i < n - 1; i++){
                if (i == 1){
                    dp[i] = Math.max(nums[0], nums[1]);
                }
                else{
                    dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
                }
            }
            int dpNMinus2 = dp[n - 2];
            Arrays.fill(dp, 0);
            dp[1] = nums[1];
            for (int i = 2; i < n; i++){
                if (i == 2){
                    dp[i] = Math.max(nums[1], nums[2]);
                }
                else{
                    dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
                }
            }

            int dpNMinus1 = dp[n - 1];
            return Math.max(dpNMinus2, dpNMinus1);
        }
    }
}