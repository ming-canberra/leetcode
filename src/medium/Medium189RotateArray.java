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

    class Solution1 {
        public void rotate(int[] nums, int k) {
            int len = nums.length;
            k = k % len;
            if (k ==0){
                return;
            }
            int startIdx = 0;
            int lastValue = nums[0];
            int curIdx = 0;
            int nextIdx = 0;
            for (int i = 0; i < len; i++){
                nextIdx = curIdx + k >= len ? curIdx + k - len : curIdx + k;
                int tmp = nums[nextIdx];
                nums[nextIdx] = lastValue;
                lastValue = tmp;
                curIdx = nextIdx;
                if (curIdx == startIdx){
                    startIdx++;
                    curIdx = startIdx;
                    if (curIdx < len)
                    {
                        lastValue = nums[curIdx];
                    }
                }
            }
        }
    }
}