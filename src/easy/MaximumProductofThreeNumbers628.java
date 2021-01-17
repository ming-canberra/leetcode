package easy;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumProductofThreeNumbers628 {
    public static void main(String[] args) {
        MaximumProductofThreeNumbers628 thisClass = new MaximumProductofThreeNumbers628();

        int[] input = {1,2,3,0};
        System.out.println(thisClass.maximumProduct(input));
    }

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);

        // 2 int <0 &&  1 int >0
        int onePositive = nums[nums.length - 1] * nums[1] * nums[0];

        // 3 int > 0
        int threePositive = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];

        if (onePositive > 0 || threePositive > 0) {
            return Math.max(onePositive, threePositive);
        }

        ArrayList<Integer> allNegatives = new ArrayList<Integer>();
        ArrayList<Integer> allPositives = new ArrayList<Integer>();
        // 0
        for (int n : nums) {
            if (n == 0) {
                return 0;
            }
            if (n < 0) {
                allNegatives.add(n);
            }
            if (n > 0) {
                allPositives.add(n);
            }
        }

        // 3 int <0
        int zeroPositive = Integer.MIN_VALUE;
        if (allNegatives.size() >= 3) {
            zeroPositive = allNegatives.get(allNegatives.size() - 1) * allNegatives.get(allNegatives.size() - 2) * allNegatives.get(allNegatives.size() - 3);
        }

        // 1 int <0 && 2 int >0
        int twoPositive = Integer.MIN_VALUE;
        if (allNegatives.size() >= 1 && allPositives.size() >= 2) {
            twoPositive = allNegatives.get(allNegatives.size() - 1) * allPositives.get(0) * allPositives.get(1);
        }

        return Math.max(zeroPositive, twoPositive);
    }
}