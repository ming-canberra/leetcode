package medium;

import java.util.*;

public class Medium0016ThreeSumClosest {
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int n = nums.length;
            int diff = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++){
                int l = i + 1;
                int r = n - 1;
                while(l < r){
                    int sum = nums[i] + nums[l] + nums[r];
                    if ( Math.abs(sum - target) < Math.abs(diff) ){
                        diff = sum - target;
                    }
                    if (sum == target){
                        return sum;
                    }
                    else if (sum > target){
                        r--;
                    }
                    else{
                        l++;
                    }
                }
            }
            return diff + target;
        }
    }

    class Solution1 {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int len = nums.length;
            int result = nums[0] + nums[1] + nums[2];
            for (int i = 0; i < len - 2; i++){
                int left = i + 1;
                int right = len - 1;
                while(left < right){
                    int sum = nums[i] + nums[left] + nums[right];
                    if (Math.abs(sum - target) < Math.abs(result - target)){
                        result = sum;
                    }
                    if (sum == target){
                        break;
                    }
                    else if (sum < target){
                        left++;
                    }
                    else{
                        right--;
                    }
                }
                if (result == target){
                    break;
                }
            }
            return result;
        }
    }
}