package medium;

import java.util.List;

public class Medium81SearchinRotatedSortedArrayII {
    class Solution {
        public boolean search(int[] nums, int target) {
            int l = 0;
            int r = nums.length - 1;
            while(l + 1 < r){
                if (nums[l] == nums[l + 1]){
                    l++;
                    continue;
                }
                if (nums[r] == nums[r - 1]){
                    r--;
                    continue;
                }
                int m = l + (r - l) / 2;
                if (nums[l] == target || nums[m] == target || nums[r] == target){
                    return true;
                }
                if (nums[l] < target && target < nums[m]){
                    r = m;
                }
                else if (nums[l] > nums[m] && ( target < nums[m] || target > nums[l] )){
                    r = m;
                }
                else{
                    l = m;
                }
            }
            if (nums[l] == target){
                return true;
            }
            if (nums[r] == target){
                return true;
            }
            return false;
        }
    }
}