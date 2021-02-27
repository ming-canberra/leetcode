package medium;

public class NonDecreasingArray665 {
    public static void main(String[] args) {
        NonDecreasingArray665 thisClass = new NonDecreasingArray665();

        boolean ans = thisClass.checkPossibility(new int[]{5,7,1,8});
        System.out.println(ans);
    }
    public boolean checkPossibility(int[] nums) {
        int firstIndex = -1;
        for (int i = 0; i<= nums.length -2; i++){
            if (nums[i]>nums[i+1]){
                if (firstIndex == -1){
                    firstIndex = i;
                }
                else{
                    return false;
                }
            }
        }
        if (firstIndex == -1){
            return true;
        }
        else{
            if (firstIndex -1 <0 || firstIndex + 2>= nums.length){
                return true;
            }
            else{
                return (nums[firstIndex -1]<=nums[firstIndex +1]) || nums[firstIndex] <= nums[firstIndex + 2];
            }
        }
    }
}