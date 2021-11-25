package medium;

public class Medium0540SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length -1;
        int m = l + (r-l)/2;
        while (l<r){
            if (nums[m] != nums[m - 1] && nums[m] != nums[m + 1]) {
                return nums[m];
            } else if (nums[m] == nums[m - 1]) {
                if ((r-m)%2 == 0){
                    r = m - 2;
                }
                else{
                    l = m + 1;
                }
            } else {
                if ((r-m)%2 == 0){
                    l = m +2;
                }
                else{
                    r = m - 1;
                }
            }
            m = l + (r - l) / 2;
        }
        return nums[m];
    }

    class Solution {
        public int singleNonDuplicate(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            while(left < right){
                int m = (left + right) / 2;
                int mLeftValue = nums[m - 1];
                int mRightValue = nums[m + 1];

                if (nums[m] != mLeftValue && nums[m] != mRightValue){
                    return nums[m];
                }
                // left has even elements
                else if (nums[m] == mLeftValue && (m - left + 1) % 2 == 0 ){
                    left = m + 1;
                }
                // left has odd elements
                else if (nums[m] == mLeftValue && (m - left + 1) % 2 == 1 ){
                    right = m;
                }
                // left has even elements
                else if (nums[m] != mLeftValue && (m - left + 1) % 2 == 0 ){
                    right = m - 1;
                }
                // left has odd elements
                else{
                    left = m;
                }
            }
            return nums[left];
        }
    }
}