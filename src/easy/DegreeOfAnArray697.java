package easy;

import java.util.ArrayList;
import java.util.HashMap;

public class DegreeOfAnArray697 {
    public static void main(String[] args) {
        DegreeOfAnArray697 thisClass = new DegreeOfAnArray697();

        System.out.println(thisClass.findShortestSubArray(new int[]{1}));
    }

    public int findShortestSubArray(int[] nums) {

        HashMap<Integer, Integer> frequency = new HashMap<Integer, Integer>();

        int maxFrequency = 0;
        ArrayList<Integer> mostFrequentInt = new ArrayList<Integer>();
        HashMap<Integer, Integer> left = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> right = new HashMap<Integer, Integer>();

        for (int i =0; i< nums.length;i++){
            if (!left.containsKey(nums[i])){
                left.put(nums[i], i);
            }

            right.put(nums[i], i);

            // first time seeing this int
            if (!frequency.keySet().contains(nums[i])){
                if (maxFrequency <= 1){
                    mostFrequentInt.add(nums[i]);
                    maxFrequency = 1;
                }

                frequency.put(nums[i], 1);
            }
            // not first time seeing this int
            else{
                if (maxFrequency < frequency.get(nums[i]) + 1){
                    mostFrequentInt.clear();
                    mostFrequentInt.add(nums[i]);
                    maxFrequency = frequency.get(nums[i]) + 1;
                }
                else if (maxFrequency == frequency.get(nums[i]) + 1){
                    mostFrequentInt.add(nums[i]);
                }

                frequency.put(nums[i], frequency.get(nums[i]) + 1);
            }
        }

        int toReturn = Integer.MAX_VALUE;

        for (Integer i : mostFrequentInt){
            toReturn = Math.min(toReturn, right.get(i) - left.get(i) +1);
        }

        return toReturn;
    }
}