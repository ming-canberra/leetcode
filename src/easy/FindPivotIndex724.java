package easy;

import java.util.ArrayList;
import java.util.List;

public class FindPivotIndex724 {
    public static void main(String[] args) {
        FindPivotIndex724 thisClass = new FindPivotIndex724();

        System.out.println(thisClass.pivotIndex( new int[]{1,7,3,6,5,6}));
    }
    public int pivotIndex(int[] nums) {

        int[] sum = new int[nums.length];
        if(nums.length > 0){
            sum[0] = nums[0];
        }
        for (int i =1;i < nums.length;  i++){
            sum[i] += sum[i-1] + nums[i];
        }

        for (int i =0; i < nums.length; i++){
            if (i == 0)
            {
                if (sum[nums.length - 1] -sum[i] == 0){
                    return i;
                }
            }
            else if (i == nums.length - 1){
                if (sum[i-1] == 0){
                    return i;
                }
            }
            else if (sum[i-1] == sum[nums.length - 1] -sum[i] ){
                return i;
            }

        }
        return -1;
    }
}