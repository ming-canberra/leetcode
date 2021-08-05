package easy;

import java.util.*;

public class RemoveElement27 {
    class Solution {
        public int removeElement(int[] nums, int val) {
            int valIndex = 0;
            int nonvalIndex = 0;
            int n = nums.length;
            while(valIndex < n){
                if (nums[valIndex] == val){
                    nonvalIndex = valIndex + 1;
                    while(nonvalIndex < n && nums[nonvalIndex] == val){
                        nonvalIndex++;
                    }
                    if (nonvalIndex < n){
                        swap(nums, valIndex, nonvalIndex);
                    }
                    else{
                        break;
                    }
                }

                valIndex++;
            }
            return valIndex;
        }
        private void swap(int[] nums, int a, int b){
            int tmp = nums[a];
            nums[a] = nums[b];
            nums[b] = tmp;
        }
    }

    class Solution1 {
        public int removeElement(int[] nums, int val) {
            int cur = -1;
            for (int i = 0; i < nums.length; i++){
                if (nums[i] != val){
                    cur++;
                    swap(nums, cur, i);
                }
            }
            return cur + 1;
        }
        private void swap(int[] nums, int a, int b){
            int tmp = nums[a];
            nums[a] = nums[b];
            nums[b] = tmp;
        }
    }
}