package medium;

public class HouseRobberII213 {
    public static void main(String[] args) {
        HouseRobberII213 thisClass = new HouseRobberII213();

        int res = thisClass.rob(new int[]{2,7,9,3,1});
        System.out.println(res);
    }
    public int rob(int[] nums) {
        int [] helperArray;

        if (nums.length ==1){
            return nums[0];
        }
        else{
            // robbing first one
            helperArray = new int[nums.length];
            helperArray[0] = nums[0];
            for (int i = 1;i< nums.length;i++){
                if (i == 1){
                    helperArray[1] = nums[0];
                }
                else if (i == nums.length -1){
                    helperArray[i] = Math.max(helperArray[i-2], helperArray[i-1]);
                }
                else{
                    helperArray[i] = Math.max(helperArray[i-2] + nums[i], helperArray[i-1]);
                }
            }
            int tempResult1 = helperArray[nums.length -1];

            //NOT robbing first one
            helperArray = new int[nums.length];
            helperArray[0] = 0;
            for (int i = 1;i< nums.length;i++){
                if (i == 1){
                    helperArray[1] = nums[1];
                }
                else{
                    helperArray[i] = Math.max(helperArray[i-2] + nums[i], helperArray[i-1]);
                }
            }
            int tempResult2 = helperArray[nums.length -1];
            return Math.max(tempResult2, tempResult1);
        }
    }
}