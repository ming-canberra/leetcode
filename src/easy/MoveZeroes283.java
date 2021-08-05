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

    class Solution {
        public void moveZeroes(int[] nums) {
            int indexZero = 0;
            int indexNonZero = 0;
            int n = nums.length;
            while (indexNonZero < n){
                while(indexZero < n && nums[indexZero] != 0){
                    indexZero++;
                }
                if (indexZero == n){
                    break;
                }
                indexNonZero = indexZero + 1;
                while(indexNonZero < n && nums[indexNonZero] == 0){
                    indexNonZero++;
                }
                if (indexNonZero == n){
                    break;
                }
                swap(nums, indexZero, indexNonZero);
                indexZero++;
            }
        }
        private void swap(int[] nums, int a, int b){
            int tmp = nums[a];
            nums[a] = nums[b];
            nums[b] = tmp;
        }
    }
}