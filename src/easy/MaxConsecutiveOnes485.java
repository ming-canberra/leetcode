package easy;

import java.util.Arrays;

public class MaxConsecutiveOnes485 {
    public static void main(String[] args) {
        MaxConsecutiveOnes485 thisClass = new MaxConsecutiveOnes485();
        System.out.println(thisClass.findMaxConsecutiveOnes(new int[]{1,2}));

        StringBuilder sb = new StringBuilder();
    }
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int currentCounter = 0;
        for (int i = 0; i < nums.length;i++){
            if (currentCounter == 0){
                if (nums[i] == 1){
                    currentCounter++;
                    max = Math.max(max, currentCounter);
                }
            }
            else{
                if (nums[i] == 1){
                    currentCounter++;
                    max = Math.max(max, currentCounter);
                }
                else{
                    currentCounter =0;
                }
            }
        }
        return max;
    }
}