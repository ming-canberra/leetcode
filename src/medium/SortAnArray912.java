package medium;

import java.util.*;

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

    class SolutionMergeSort {
        int[] original;
        public int[] sortArray(int[] nums) {
            original = Arrays.copyOf(nums, nums.length);
            for (int i : original){
                System.out.println(i);
            }
            mergeSort(nums, 0, nums.length - 1);
            return nums;
        }
        private void mergeSort(int[] nums, int start, int end){
            if (start >= end){
                return;
            }
            int m = start + (end - start) / 2;
            mergeSort(nums, start, m);
            mergeSort(nums, m + 1, end);
            merge(nums, start, end);
        }
        private void merge(int[] nums, int start, int end){
            int m = start + (end - start) / 2;
            int iNums = start;
            int l = start;
            int r = m + 1;
            while(l <= m && r <= end){
                if (original[l] > original[r]){
                    nums[iNums] = original[r];
                    r++;
                }
                else{
                    nums[iNums] = original[l];
                    l++;
                }
                iNums++;
            }
            while(l <= m){
                nums[iNums] = original[l];
                l++;
                iNums++;
            }
            while(r <= end){
                nums[iNums] = original[r];
                r++;
                iNums++;
            }
            for (int i = start; i <= end; i++){
                original[i] = nums[i];
            }
        }
    }
}