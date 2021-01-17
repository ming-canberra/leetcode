package easy;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrangingCoins441 {
    public static void main(String[] args) {
        ArrangingCoins441 thisClass = new ArrangingCoins441();

        thisClass.arrayPairSum(new int[] {1,4,3,2});
    }
    //do binary search
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);

        int i = 0;
        int toReturn = 0;
        while (i< nums.length){
            toReturn += nums[i];

            i+=2;
        }

        return toReturn;
    }
}