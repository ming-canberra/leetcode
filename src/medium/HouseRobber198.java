package medium;

public class HouseRobber198 {
    public int rob(int[] nums) {
        int [] helperArray = new int[nums.length];
        helperArray[0] = nums[0];
        for (int i = 1; i < nums.length;i++){
            if (i == 1){
                helperArray[1] = Math.max(helperArray[0], nums[1]);
            }
            else{
                helperArray[i] = Math.max(helperArray[i-2] + nums[i], helperArray[i-1]);
            }
        }
        return helperArray[nums.length -1];
    }

    class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            if (n == 1){
                return nums[0];
            }
            int[] dp = new int[n];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < n; i++){
                dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
            }
            return dp[n - 1];
        }
    }
}