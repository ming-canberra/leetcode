package medium;

public class Medium1060MissingElementinSortedArray {
    class Solution {
        public int missingElement(int[] nums, int k) {
            int len = nums.length;

            int missedNumWholeArray = nums[len - 1] - nums[0] + 1 - len;

            if (k > missedNumWholeArray){
                return nums[len - 1] + k - missedNumWholeArray;
            }
            else{
                // find the element furthest to the left where the missing num >= k

                int left = 0;
                int right = len;

                while (left + 1 < right){
                    int m = (left + right) / 2;

                    int numMissing = nums[m] - nums[0] - (m - 0);
                    if (numMissing >= k){
                        right = m;
                    }
                    else{
                        left = m;
                    }
                }
                // element at right is what we need

                return nums[right - 1] + k - (   nums[right - 1] - nums[0] - (right - 1 - 0)  );
            }
        }
    }
}