package medium;

public class SingleElementInASortedArray540 {
    public static void main(String[] args) {
        SingleElementInASortedArray540 thisClass = new SingleElementInASortedArray540();
        int res = thisClass.singleNonDuplicate(new int[]{3,3,7,7,10,11,11});
        ///int res = thisClass.singleNonDuplicate(new int[]{1,1,3,5,5,7,7,8,8});

        System.out.println(res);
    }
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
}