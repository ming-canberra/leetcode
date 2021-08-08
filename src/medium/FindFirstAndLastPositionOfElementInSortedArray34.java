package medium;

public class FindFirstAndLastPositionOfElementInSortedArray34 {
    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray34 thisClass = new FindFirstAndLastPositionOfElementInSortedArray34();
        System.out.println (thisClass.searchRange(new int[]{5,7,7,8,8,10}, 8));
    }
    public int[] searchRange(int[] nums, int target) {

        int startResult = -1;

        int l = -1;
        int r = nums.length;

        while (l + 1 < r){
            int m = l + (r - l) / 2;

            if(nums[m] < target){
                l = m;
            }
            else{
                r = m;
            }
        }
        if (r == nums.length || nums[r] != target){
            return new int[]{-1, -1};
        }
        startResult = r;

        int endResult = 0;
        l = r -1;
        r = nums.length;

        while (l + 1 < r){
            int m = l + (r - l) / 2;
            if(nums[m] <= target){
                l = m;
            }
            else{
                r = m;
            }
        }
        endResult = l;

        return new int[]{startResult, endResult};
    }

    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int l = -1;
            int r = nums.length;
            while(l + 1 < r){
                int m = l + (r - l) / 2;
                if (nums[m] == target){
                    int start = m;
                    int end = m;
                    while(start >= 0 && nums[start] == target){
                        start--;
                    }
                    while(end < nums.length && nums[end] == target){
                        end++;
                    }
                    return new int[]{start + 1, end - 1};
                }
                else if (nums[m] < target){
                    l = m;
                }
                else{
                    r = m;
                }
            }
            return new int[]{-1, -1};
        }
    }
}