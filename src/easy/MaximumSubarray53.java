package easy;

public class MaximumSubarray53 {
    public static void main(String[] args) {
        MaximumSubarray53 thisClass = new MaximumSubarray53();

        System.out.println(thisClass.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
    public int maxSubArray(int[] nums) {

        int ans = Integer.MIN_VALUE;
        int current = Integer.MIN_VALUE;
        for (int i =0;i < nums.length;i++){
            if (nums[i]>0){
                if (current <=0){
                    current = nums[i];
                }
                else{
                    current +=nums[i];
                }
            }
            else{
                if (current <=0){
                    current = nums[i];
                }
                else{
                    current +=nums[i];
                }
            }
            ans = Math.max(ans, current);
        }

        return ans;
    }
}