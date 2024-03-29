package easy;

import java.util.Arrays;

public class SquaresofaSortedArray977 {
    class Solution {
        public int[] sortedSquares(int[] nums) {
            int indexOrigin = 0;
            for (int i = 1; i < nums.length; i++){
                if (Math.abs(nums[i] - 0) < Math.abs(nums[indexOrigin] - 0)){
                    indexOrigin = i;
                }
            }
            int left = indexOrigin - 1;
            int right = indexOrigin + 1;
            int[] result = new int[nums.length];
            result[0] = nums[indexOrigin] * nums[indexOrigin];
            int curIndex = 1;
            while(left >= 0 || right < nums.length){
                if (left < 0){
                    result[curIndex] = nums[right] * nums[right];
                    right++;
                }
                else if (right >= nums.length){
                    result[curIndex] = nums[left] * nums[left];
                    left--;
                }
                else{
                    if (Math.abs(nums[left] - 0) < Math.abs(nums[right] - 0)){
                        result[curIndex] = nums[left] * nums[left];
                        left--;
                    }
                    else{
                        result[curIndex] = nums[right] * nums[right];
                        right++;
                    }
                }
                curIndex++;
            }
            return result;
        }
    }

    class SolutionLogN {
        public int[] sortedSquares(int[] nums) {
            int n = nums.length;
            int[] result = new int[n];
            int l = 0;
            int r = n - 1;
            for (int i = n - 1; i >= 0; i--){
                if (Math.abs(nums[l]) > Math.abs(nums[r])){
                    result[i] = nums[l] * nums[l];
                    l++;
                }
                else{
                    result[i] = nums[r] * nums[r];
                    r--;
                }
            }
            return result;
        }
    }
}