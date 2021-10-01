package medium;

import java.util.List;

public class Medium0081SearchinRotatedSortedArrayII {
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

    class Solution1 {
        public boolean search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while(left + 1 < right){
                if (nums[left] == target || nums[right] == target){
                    return true;
                }
                while(left + 1 < right && nums[left] == nums[left + 1]){
                    left++;
                }
                while(left + 1 < right && nums[right] == nums[right - 1]){
                    right--;
                }
                if (left + 1 == right){
                    break;
                }
                else{
                    int m = left + (right - left) / 2;
                    if (nums[m] == target){
                        return true;
                    }
                    else if (nums[m] > target && target > nums[left]){
                        right = m;
                    }
                    else if ( ( target > nums[left] || target < nums[m] ) && nums[m] < nums[left] && nums[m] < nums[right]  ){
                        right = m;
                    }
                    else{
                        left = m;
                    }
                }
            }
            return nums[left] == target || nums[right] == target;
        }
    }
}