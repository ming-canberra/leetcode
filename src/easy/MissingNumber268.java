package easy;

public class MissingNumber268 {
    public static void main(String[] args) {
        MissingNumber268 thisClass = new MissingNumber268();

        int[] input = {1,2,3,0};
        int result = thisClass.missingNumber(input);
        System.out.println(result);
    }

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int biggerSum = (n* (n+1)) /2;

        int smallerSum = 0;
        for (int i =0;i< n ;i ++)
        {
            smallerSum += nums[i];
        }

        return biggerSum- smallerSum;
    }
}