package hard;

public class Hard0154FindMinimuminRotatedSortedArrayII {

    class Solution {
        public int findMin(int[] nums) {
            int l = 0;
            int r = nums.length - 1;
            while(l + 1 < r){
                int m = (l + r) / 2;
                if (nums[l] == nums[m]){
                    while(nums[l] == nums[m] && l != m){
                        l++;
                    }
                    continue;
                }
                if (nums[r] == nums[m]){
                    while(nums[r] == nums[m] && r != m){
                        r--;
                    }
                    continue;
                }
                if (nums[l] == nums[r]){
                    while(nums[l] == nums[r] && l + 1 < r){
                        l++;
                    }
                    continue;
                }
                if (nums[m] > nums[l] && nums[m] > nums[r]){
                    l = m;
                }
                else{
                    r = m;
                }
            }
            return nums[l] < nums[r] ? nums[l] : nums[r];
        }
    }


}