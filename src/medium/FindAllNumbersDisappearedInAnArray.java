package medium;

import java.util.*;

public class FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        FindAllNumbersDisappearedInAnArray thisClass = new FindAllNumbersDisappearedInAnArray();
        System.out.println (thisClass.findDisappearedNumbersSorting(new int[]{1,1}));
    }
    /**
     * O(n) time, no extra space
     * */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            nums[index] = Math.abs(nums[index]) * (-1);
        }
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                result.add(i + 1);
            }
        }
        return result;
    }

    /**
     * O(n) space
     * */
    public List<Integer> findDisappearedNumbersNSpace(int[] nums) {
        boolean helper[] = new boolean[nums.length];
        for (int i : nums){
            helper[i - 1] = true;
        }
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < helper.length; i++){
            if (!helper[i]){
                result.add(i + 1);
            }
        }
        return result;
    }

    /**
     * O(nlogn) time
     * */
    public List<Integer> findDisappearedNumbersSorting(int[] nums) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<Integer>();
        int expectedNumber = 1;
        for (int i = 0; i <nums.length; i++){
            if (nums[i] > expectedNumber){
                for (int j = expectedNumber; j < nums[i]; j++) {
                    result.add(j);
                }
                expectedNumber = nums[i] + 1;
            }
            else if (nums[i] == expectedNumber){
                expectedNumber = nums[i] + 1;
            }
        }
        if(nums[nums.length - 1] < nums.length){
            for (int i = expectedNumber;i<= nums.length;i++){
                result.add(i);
            }
        }
        return result;
    }
}