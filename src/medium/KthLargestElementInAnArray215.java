package medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class KthLargestElementInAnArray215 {
    public static void main(String[] args) {
        KthLargestElementInAnArray215 thisClass = new KthLargestElementInAnArray215();
        System.out.println(" " + thisClass.findKthLargest(new int[]{17,13,11,2,3,5,7}, 3));
    }
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length -k];
    }
}