package medium;

import java.util.Arrays;

public class Medium0324WiggleSortII {
    class Solution {
        public void wiggleSort(int[] nums) {
            Arrays.sort(nums);

            int[] copies = new int[nums.length];

            for (int i = 0; i < nums.length; i++) {

                copies[i] = nums[i];
            }

            int oddIdx = (nums.length - 1) / 2;
            int evenIdx = nums.length - 1;

            boolean doingOdd = true;
            for(int i = 0; i < nums.length; i++) {
                if (doingOdd) {
                    nums[i] = copies[oddIdx];
                    oddIdx--;
                }
                else {
                    nums[i] = copies[evenIdx];
                    evenIdx--;
                }
                doingOdd = !doingOdd;
            }
        }
    }
}