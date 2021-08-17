package medium;

public class FindMinimumInRotatedSortedArray153 {
    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray153 thisClass = new FindMinimumInRotatedSortedArray153();
        System.out.println (thisClass.findMin(new int[]{4,5,6,7,0,1,2}));
    }
    public int findMin(int[] nums) {
        return fun(nums,  0, nums.length - 1);
    }

    private int fun(int[] nums, int l, int r){
        if (nums[l] <= nums[r]){
            return nums[l];
        }
        if (r -l == 1){
            return Math.min(nums[r], nums[l]);
        }
        int m = l + (r-l)/2;

        if (nums[l] < nums[m]){
            return fun (nums, m, r);
        }
        else{
            return fun (nums, l, m);
        }
    }

    class Solution {
        public int findMin(int[] nums) {
            int l = 0;
            int r = nums.length - 1;
            while(l + 1 < r){
                int m = l + (r - l) / 2;
                if (nums[r] > nums[m] && nums[m] > nums[l]){
                    return nums[l];
                }
                else if (nums[m] > nums[l] && nums[m] > nums[r]){
                    l = m;
                }
                else if (nums[m] < nums[l] && nums[m] < nums[r]){
                    r = m;
                }
            }
            return nums[l] < nums[r] ? nums[l] : nums[r];
        }
    }
}