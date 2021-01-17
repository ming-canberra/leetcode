package easy;

public class BinarySearch704 {
    public static void main(String[] args) {
        BinarySearch704 thisClass = new BinarySearch704();

        int[] s1 = {1,3,5,9,10};


        System.out.println(thisClass.search(s1, 3));
    }
    public int search(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;

        if (target <nums[l] || target > nums[r]){
            return -1;
        }

        while (l < r){
            if (nums[l] == target){
                return l;
            }
            else if (nums[r] ==  target){
                return r;
            }

            if (r - l == 1){
                return -1;
            }

            int m = l + (r - l)/2;

            if (target >= nums[m]){
                l=m;
            }
            else{
                r = m;
            }
        }

        if (l == r){
            if (nums[l] == target){
                return l;
            }
        }

        return -1;
    }
}