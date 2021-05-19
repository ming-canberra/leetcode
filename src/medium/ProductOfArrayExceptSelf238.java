package medium;

import java.util.*;

public class ProductOfArrayExceptSelf238 {
    public static void main(String[] args) {
        ProductOfArrayExceptSelf238 thisClass = new ProductOfArrayExceptSelf238();
    }
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] lProducts = new int[nums.length];
        lProducts[0] = nums[0];
        for (int i = 1; i < nums.length - 1; i++){
            lProducts[i] = lProducts[i - 1] * nums[i];
        }
        int[] rProducts = new int[nums.length];
        rProducts[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i > 0; i--){
            rProducts[i] = rProducts[i + 1] * nums[i];
        }

        int[] result = new int[nums.length];

        result[0] = rProducts[1];
        result[length - 1] = lProducts[length - 2];

        for (int i = 1; i < length - 1; i++){
            result[i] = rProducts[i + 1] * lProducts[i - 1];
        }

        return result;
    }
}