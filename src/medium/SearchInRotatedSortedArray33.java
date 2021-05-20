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
}