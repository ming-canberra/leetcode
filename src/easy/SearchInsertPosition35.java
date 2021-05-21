package easy;

public class SearchInsertPosition35 {
    public static void main(String[] args) {
        SearchInsertPosition35 thisClass = new SearchInsertPosition35();
    }

    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        while(l < r){
            int m = l + (r - l) / 2;
            if (target == nums[m]){
                return m;
            }
            else if (target > nums[m]){
                l = m + 1;
            }
            else{
                r = m;
            }
        }

        if (l == nums.length){
            return l;
        }
        else if (target > nums[l]){
            return l + 1;
        }
        else{
            return l;
        }
    }
}