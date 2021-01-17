package easy;

import java.util.HashMap;
import java.util.HashSet;

public class LongestHarmoniousSubsequence594 {
    public static void main(String[] args) {
        LongestHarmoniousSubsequence594 thisClass = new LongestHarmoniousSubsequence594();

        int nums[] = {1,3,2,2,4,2,3,7};

        System.out.println(
                thisClass.findLHS(nums)
        );
    }
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> numFrequency = new HashMap<Integer, Integer>();
        for (int i =0;i< nums.length; i++){
            if (numFrequency.containsKey(nums[i])){
                numFrequency.put(nums[i], numFrequency.get(nums[i]) + 1);
            }
            else{
                numFrequency.put(nums[i], 1);
            }
        }
        int maxLength = 0;
        for (Integer i : numFrequency.keySet()){
            if (numFrequency.containsKey(i +1)){
                maxLength = Math.max(maxLength, numFrequency.get(i) + numFrequency.get(i+1));
            }
        }
        return maxLength;
    }
}