package medium;

public class MaxConsecutiveOnesII487 {
    class Solution {
        private int result = 0;
        public int findMaxConsecutiveOnes(int[] nums) {
            int n = nums.length;
            int nextZeroIndex = getNextZero(nums, 0);
            while(nextZeroIndex + 1 < n){
                nextZeroIndex = getNextZero(nums, nextZeroIndex + 1);
            }
            return result;
        }
        private int getNextZero(int[] nums, int start){
            boolean fliped = false;
            int count = 0;
            int nextZeroIndex = nums.length;
            for (int i = start; i < nums.length;i++){
                if (nums[i] == 0){
                    if (!fliped){
                        nextZeroIndex = i;
                        fliped = true;
                        count++;
                    }
                    else{
                        break;
                    }
                }
                else{
                    count++;
                }
            }
            result = Math.max(result, count);
            return nextZeroIndex;
        }
    }

    class Solution1 {
        public int findMaxConsecutiveOnes(int[] nums) {
            int result = 0;
            int comResult = 0;
            int oneCounter = 0;
            for (int i = 0; i < nums.length; i++){
                if (nums[i] == 1){
                    oneCounter++;
                }
                else{
                    if (comResult != 0){
                        result = Math.max(result, comResult + oneCounter);
                    }
                    comResult = oneCounter + 1;
                    oneCounter = 0;
                }
                if (i == nums.length - 1){
                    result = Math.max(result, comResult + oneCounter);
                }
            }
            return result;
        }
    }
}