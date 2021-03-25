package medium;

import java.util.Arrays;

public class TargetSum494 {
    public static void main(String[] args) {
        TargetSum494 thisClass = new TargetSum494();

        int res = thisClass.findTargetSumWays(new int[]{1,1,1,1,1}, 3);
        System.out.println(res);
    }
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null){
            return 0;
        }

        int[] last = new int[2];
        last[0] = nums[0];
        last[1] = -nums[0];

        for ( int i = 1; i < nums.length; i++)
        {
            int[] current = Arrays.copyOf(last, last.length * 2);
            for (int j = 0; j < last.length; j++){
                current[last.length +j] = last[j] - nums[i];
                current[j] = last[j] + nums[i];
            }
            last = current;
        }

        int toReturn = 0;
        for (int i : last){
            if (i == S){
                toReturn++;
            }
        }

        return toReturn;
    }
}