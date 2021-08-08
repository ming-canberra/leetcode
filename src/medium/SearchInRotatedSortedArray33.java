package medium;

import java.util.*;

public class SearchInRotatedSortedArray33 {
    public static void main(String[] args) {
        SearchInRotatedSortedArray33 thisClass = new SearchInRotatedSortedArray33();
    }
    public int search(int[] nums, int target) {
        return search (nums, target, 0, nums.length);
    }
    //excluding end
    private int search(int[] nums, int target, int start, int end){
        if (end > start){
            int m = start + (end - start) / 2;
            if (target == nums[m]){
                return m;
            }
            // left is binary
            if (nums[start] < nums[m]){
                if (target < nums[m] && target >= nums[start]){
                    return binarySearch(nums, target, start, m);
                }
                else{
                    return search(nums, target, m + 1, end);
                }
            }
            // right is binary
            else{
                if (target > nums[m] && target <= nums[end - 1]){
                    return binarySearch(nums, target, m + 1, end);
                }
                else{
                    return search(nums, target, start, m);
                }
            }
        }
        else{
            return -1;
        }
    }
    //excluding end
    private int binarySearch(int[] nums, int target, int start, int end){
        if (end > start){
            int m = start + (end - start) / 2;
            if (target == nums[m]){
                return m;
            }
            else if (target > nums[m]){
                return binarySearch(nums, target, m + 1, end);
            }
            else{
                return binarySearch(nums, target, start, m);
            }
        }
        else{
            return -1;
        }
    }

    class Solution {
        public int search(int[] nums, int target) {
            int l = 0;
            int r = nums.length - 1;
            while (l <= r){
                int m = l + (r - l) / 2;
                if (nums[m] == target){
                    return m;
                }
                if (nums[l] == target){
                    return l;
                }
                if (nums[r] == target){
                    return r;
                }
                if (target > nums[m] && target < nums[r]){
                    l = m + 1;
                    r = r - 1;
                }
                else if (target > nums[l] && target < nums[m]){
                    l = l + 1;
                    r = m - 1;
                }
                else if (nums[m] > nums[r]){
                    l = m + 1;
                    r = r - 1;
                }
                else if (nums[m] < nums[l]){
                    l = l + 1;
                    r = m - 1;
                }
                else{
                    break;
                }
            }
            return -1;
        }
    }
}