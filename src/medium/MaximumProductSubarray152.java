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

    class Solution {
        public int maxProduct(int[] nums) {
            int n = nums.length;
            int result = nums[0];
            int cur = 1;
            for (int i = 0; i < n; i++){
                cur = cur * nums[i];
                result = Math.max(cur, result);
                if (nums[i] == 0){
                    cur = 1;
                }
            }
            cur = 1;
            for (int i = n - 1; i >= 0; i--){
                cur = cur * nums[i];
                result = Math.max(cur, result);
                if (nums[i] == 0){
                    cur = 1;
                }
            }
            return result;
        }
    }

    class Solution1 {
        public int maxProduct(int[] nums) {
            int len = nums.length;
            int pProd = 0;
            int nProd = 0;
            int result = nums[0];
            for (int i = 0; i < len; i++){
                result = Math.max(result, nums[i]);
                if (nums[i] == 0){
                    pProd = 0;
                    nProd = 0;
                }
                else{
                    if (nums[i] > 0){
                        if (pProd == 0){
                            pProd = nums[i];
                        }
                        else{
                            pProd *= nums[i];
                        }
                        if (nProd != 0){
                            nProd *= nums[i];
                        }
                    }
                    else{
                        if (pProd == 0 && nProd == 0){
                            nProd = nums[i];
                        }
                        else if (pProd != 0 && nProd == 0){
                            nProd = pProd * nums[i];
                            pProd = 0;
                        }
                        else if (pProd == 0 && nProd != 0){
                            pProd = nProd * nums[i];
                            nProd = nums[i];
                        }
                        else{
                            int tmp = pProd * nums[i];
                            pProd = nProd * nums[i];
                            nProd = tmp;
                        }
                    }
                    if (pProd != 0){
                        result = Math.max(result, pProd);
                    }
                    if (nProd != 0){
                        result = Math.max(result, nProd);
                    }
                }
            }
            return result;
        }
    }
}