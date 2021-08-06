package medium;

import java.util.*;

public class ThreeSumClosest16 {
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
}