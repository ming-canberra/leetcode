package medium;

import java.util.*;

public class NextPermutation31 {
    public static void main(String[] args) {
        NextPermutation31 thisClass = new NextPermutation31();
    }
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        if (length == 1){
            return;
        }
        int l = length - 2;
        while (l != -1)
        {
            if (nums[l] < nums[l + 1]){

                int indexX = length - 1;
                while(nums[indexX] <= nums[l]){
                    indexX--;
                }
                // swap
                swap(nums, l, indexX);
                reorder(nums, l + 1, length - 1);
                return;
            }
            l--;
        }
        reorder(nums, 0, length - 1);
    }
    private void swap(int[]nums, int l, int r){
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
    // inclusive
    private void reorder(int[]nums, int start, int end){
        while(start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}