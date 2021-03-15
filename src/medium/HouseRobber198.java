package medium;

public class HouseRobber198 {
    public static void main(String[] args) {
        HouseRobber198 thisClass = new HouseRobber198();

        int res = thisClass.rob(new int[]{2,7,9,3,1});
        System.out.println(res);
    }
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
}