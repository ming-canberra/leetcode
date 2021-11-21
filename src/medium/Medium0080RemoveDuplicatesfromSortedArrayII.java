package medium;

import java.util.*;

public class Medium0080RemoveDuplicatesfromSortedArrayII {
    class Solution {
        public int removeDuplicates(int[] nums) {
            int left = 0;
            int markedCounter = 0;
            for (int i = 0; i < nums.length; i++){
                if(nums[i] != nums[left]){
                    if (i - left <= 2){
                        left = i;
                    }
                    else{
                        while(i - left > 2){
                            nums[left] = nums[i];
                            left++;
                            markedCounter++;
                        }
                        left = i;
                    }
                }
                else{
                    if (i == nums.length - 1){
                        if (i - left >= 2){
                            while(i - left >= 2){
                                nums[left] = nums[i];
                                left++;
                                markedCounter++;
                            }
                        }
                    }
                }
            }

            return nums.length - markedCounter;
        }

    }
}