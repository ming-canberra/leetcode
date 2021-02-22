package medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class KthLargestElementInAnArray215 {
    public static void main(String[] args) {
        KthLargestElementInAnArray215 thisClass = new KthLargestElementInAnArray215();
        System.out.println(" " + thisClass.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }
    public int findKthLargest2(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length -k];
    }

    public int findKthLargest(int[] nums, int k) {
        rearragePivoting(nums, 0, nums.length -1);
        return nums[nums.length -k];
    }

    private void rearragePivoting(int[] nums, int l, int r){
        if (l <r){
            int rValue = nums[r];
            int startIndex = l;
            for (int i = l; i <r; i++){
                if(nums[i] <= rValue){
                    swap(nums, startIndex++, i);
                }
            }
            swap(nums, startIndex, r);


            int pivotIndex = startIndex;

            rearragePivoting(nums, l, pivotIndex -1);

            rearragePivoting(nums,pivotIndex + 1, r);

        }
    }

    private void swap (int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}