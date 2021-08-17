package medium;

import java.util.*;

public class FindPeakElement162 {

    class Solution {
        public int findPeakElement(int[] nums) {
            int l = -1;
            int r = nums.length;
            while(l + 1 < r){
                int m = (l + r) / 2;
                if (m + 1 == nums.length){
                    return m;
                }
                if (nums[m] > nums[m + 1]){
                    r = m;
                }
                else{
                    l = m;
                }
            }
            if (r != nums.length){
                return r;
            }
            return l;
        }
    }
}