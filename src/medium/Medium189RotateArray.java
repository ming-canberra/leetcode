package medium;

import java.util.Arrays;
import java.util.Comparator;

public class Medium189RotateArray {
    class Solution {
        public void rotate(int[] nums, int k) {
            int len = nums.length;
            k = k % len;
            int[] tmp = Arrays.copyOf(nums, nums.length);
            for (int i = 0; i < len; i++){
                int tIdx = i + k >= len ? i + k - len : i + k;
                nums[tIdx] = tmp[i];
            }
        }
    }
}