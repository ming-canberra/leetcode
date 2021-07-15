package medium;

public class SortAnArray912 {
    class Solution {
        public int[] sortArray(int[] nums) {
            quickSort(nums, 0, nums.length - 1);
            return nums;
        }
        private void quickSort(int[] nums, int start, int end){
            if (start >= end){
                return;
            }
            int sortedIndex = partition(nums, start, end);
            quickSort(nums, start, sortedIndex - 1);
            quickSort(nums, sortedIndex + 1, end);
        }
        private int partition(int[] nums, int start, int end){
            int lastValue = nums[end];
            int targetIndex = start - 1;
            for (int i = start; i < end; i++){
                if (nums[i] >= lastValue){
                }
                else{
                    targetIndex++;
                    swap(nums, i, targetIndex);
                }
            }
            targetIndex++;
            swap(nums, end, targetIndex);
            return targetIndex;
        }
        private void swap(int[] nums, int a, int b){
            int tmp = nums[a];
            nums[a] = nums[b];
            nums[b] = tmp;
        }
    }
}