package easy;

import java.util.HashSet;

public class LargestNumberAtLeastTwiceofOthers747 {
    public static void main(String[] args) {
        LargestNumberAtLeastTwiceofOthers747 thisClass = new LargestNumberAtLeastTwiceofOthers747();
        System.out.println(thisClass.dominantIndex(new int[]{3,6,1,0}));
    }
    public int dominantIndex(int[] nums) {
        if (nums.length == 1){
            return 0;
        }
        else{
            int l = 0;
            int s = 1;
            for (int i =0; i < nums.length;i++){
                if (i == 0){
                    if (nums[0] <= nums[1]){
                        l=1;
                        s=0;
                    }
                }
                else if (nums[i] > nums[l] ){
                    s = l;
                    l = i;
                }
                else if (nums[i] > nums[s]&& i!=l){
                    s = i;
                }
            }
            if (nums[l] >= 2* nums[s]){
                return l;
            }
            else{
                return -1;
            }
        }
    }
}