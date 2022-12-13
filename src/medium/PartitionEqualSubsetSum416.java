package medium;

public class PartitionEqualSubsetSum416 {
    public static void main(String[] args) {
        PartitionEqualSubsetSum416 thisClass = new PartitionEqualSubsetSum416();
        boolean dfa = thisClass.canPartition(new int[]{1, 2, 5});
        System.out.println(dfa);
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;

        boolean[] canSumTo = new boolean[target + 1];

        for (int num : nums) {
            for (int j = canSumTo.length - 1; j >= 0; j--) {
                if (j == 0)canSumTo[j] = true;
                if (canSumTo[j] && (j + num) < canSumTo.length) {
                    canSumTo[j + num] = true;
                }
            }
        }
        return canSumTo[target];
    }
    class solution
    {
        public boolean canPartition(int[] nums)
        {
            if (nums.length == 1){
                return false;
            }

            int sum = 0;
            for (int n : nums){
                sum+=n;
            }

            if (sum%2!=0){
                return false;
            }
            int target = sum/2;

            boolean [][]dp = new boolean[nums.length][target + 1];
            for (int i = 0;i < dp.length;i++){
                for (int j = 1;j < dp[0].length; j++){
                    if (i == 0){
                        if (nums[i] == j){
                            dp[i][j] = true;
                        }
                    }
                    else {
                        boolean temp = false;
                        if (j - nums[i] > 0) {
                            temp = dp[i - 1][j - nums[i]];
                        }
                        else if (j - nums[i] == 0){
                            temp = true;
                        }
                        dp[i][j] = dp[i - 1][j] || temp;
                    }
                }
            }

            return dp[dp.length - 1][dp[0].length - 1];
        }
    }
}