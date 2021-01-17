package easy;

public class MaximumAverageSubarrayI643 {
    public static void main(String[] args) {
        MaximumAverageSubarrayI643 thisClass = new MaximumAverageSubarrayI643();
        System.out.println(thisClass.findMaxAverage(new int[]{1,12,-5,-6,50,3},4));
    }

    public double findMaxAverage(int[] nums, int k) {

        int [] sums = new int[nums.length];
        sums[0] = nums[0];

        for (int i = 1; i < nums.length;i++)
        {
            sums[i] = sums[i-1] + nums[i];
        }

        double toReturn = sums[k-1];
        for (int i = k; i < nums.length; i++)
        {
            toReturn = Math.max(toReturn, sums[i] - sums[i-k]);
        }

        return toReturn/k;
    }
}