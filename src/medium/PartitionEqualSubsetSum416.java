package medium;

import java.util.Arrays;

public class PartitionEqualSubsetSum416 {
    public static void main(String[] args) {
        PartitionEqualSubsetSum416 thisClass = new PartitionEqualSubsetSum416();
        boolean dfa = thisClass.canPartition(new int[]{1,3,4,5,6});
        System.out.println(dfa);
    }

    public boolean canPartition(int[] nums)
    {
        if (nums.length == 1){
            return false;
        }
        int sum = 0;
        for (int n : nums){
            sum+=n;
        }
        if (sum % 2 == 1){
            return false;
        }
        sum = sum /2 ;

        Arrays.sort(nums);
        if (nums[nums.length - 1] > sum){
            return false;
        }


        return false;
    }
}