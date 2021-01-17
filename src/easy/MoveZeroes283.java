package easy;

public class MoveZeroes283 {
    public static void main(String[] args) {
        MoveZeroes283 thisClass = new MoveZeroes283();
        int[] input = new int[]{0,1,2,0,3,0,4,5,0};
      thisClass.moveZeroes(input);

      for (int i = 0; i < input.length; i++){
          System.out.println(input[i]);
      }
    }
    public void moveZeroes(int[] nums) {
        int starting0Index = 0;
        int number0 = 0;
        for (int i= 0; i < nums.length; i++){
            if(nums[i] == 0 ){
                if (starting0Index == 0){
                    starting0Index = i ;
                }
                number0++;
            }
            else{
                if (number0 > 0){
                    nums[i - number0] = nums[i];
                    nums[i] = 0;
                }
            }
        }
    }
}