package hard;

import java.util.*;

public class Hard0041FirstMissingPositive {
    class Solution {
        public int firstMissingPositive(int[] nums) {
            int len = nums.length;

            for (int i = 0; i < len; i++){

                while(nums[i] != i + 1){
                    if (nums[i] - 1 >= 0 && nums[i] - 1 < len){
                        if (nums[nums[i] - 1] == nums[i]){
                            break;
                        }
                        swap(nums, i, nums[i] - 1);
                    }
                    else{
                        break;
                    }
                }

            }

            for (int i = 0; i < len; i++){
                if (nums[i] != i + 1){
                    return i + 1;
                }
            }
            return len + 1;
        }

        private void swap(int[] nums, int a, int b){
            int tmp = nums[a];
            nums[a] = nums[b];
            nums[b] = tmp;
        }
    }
}