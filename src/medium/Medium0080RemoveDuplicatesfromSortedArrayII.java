package medium;

import java.util.*;

public class Medium0080RemoveDuplicatesfromSortedArrayII {
    class Solution {
        public int removeDuplicates(int[] nums) {
            int marker = Integer.MAX_VALUE;
            int left = 0;
            int markedCounter = 0;
            for (int i = 0; i < nums.length; i++){
                if(nums[i] != nums[left]){
                    if (i - left <= 2){
                        left = i;
                    }
                    else{
                        // mark them as marker
                        while(i - left > 2){
                            nums[left] = marker;
                            left++;
                            markedCounter++;
                        }
                        left = i;
                    }
                }
                else{
                    if (i == nums.length - 1){
                        if (i - left >= 2){
                            // mark them as marker
                            while(i - left >= 2){
                                nums[left] = marker;
                                left++;
                                markedCounter++;
                            }
                        }
                    }
                }
            }

            left = 0;
            int right = 0;

            while(left < nums.length && right < nums.length){
                while(right < nums.length && nums[right] == marker){
                    right++;
                }
                if (right <  nums.length){
                    nums[left] = nums[right];
                    left++;
                    right++;
                }
            }
            return nums.length - markedCounter;
        }

    }
}