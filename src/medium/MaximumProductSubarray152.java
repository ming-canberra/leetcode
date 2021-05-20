package medium;

public class MaximumProductSubarray152 {
    public static void main(String[] args) {
        MaximumProductSubarray152 thisClass = new MaximumProductSubarray152();
    }

    public int maxProduct(int[] nums) {
        int length = nums.length;
        int[][] dp = new int[length][2];

        int result = nums[0];

        if (nums[0] > 0){
            dp[0][0] = nums[0];
            dp[0][1] = 1;
        }
        else if (nums[0] < 0){
            dp[0][1] = nums[0];
            dp[0][0] = 1;
        }
        else{
            dp[0][0] = 1;
            dp[0][1] = 1;
        }

        for (int i = 1; i < length; i++){
            if (nums[i] > 0)
            {
                dp[i][0] = dp[i - 1][0] * nums[i];
                result = Math.max(result, dp[i][0]);

                if (dp[i - 1][1] < 0){
                    dp[i][1] = dp[i - 1][1] * nums[i];
                    result = Math.max(result, dp[i][1]);
                }
                else{
                    dp[i][1] = 1;
                }
            }
            else if (nums[i] < 0){
                if (dp[i - 1][1] == 1){
                    dp[i][0] = 1;
                }
                else{
                    dp[i][0] = dp[i - 1][1] * nums[i];
                    result = Math.max(result, dp[i][0]);
                }

                dp[i][1] = dp[i - 1][0] * nums[i];
                result = Math.max(result, dp[i][1]);
            }
            else{
                dp[i][0] = 1;
                dp[i][1] = 1;
                result = Math.max(result, 0);
            }
        }
        return result;
    }
}