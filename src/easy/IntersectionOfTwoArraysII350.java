package easy;

import java.util.ArrayList;
import java.util.HashMap;

public class IntersectionOfTwoArraysII350 {
    public static void main(String[] args) {
        IntersectionOfTwoArraysII350 thisClass = new IntersectionOfTwoArraysII350();

        int[] input1 = {2,2,1,0,4,5,6};
        int[] input2 = {1,2,2,1,3,1,2};

        int[] result = thisClass.intersect(input1, input2);

        for (int integer : result) {
            System.out.println(integer);
        }
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> nums1HashMap = new HashMap<Integer, Integer>();

        for (int integer : nums1){
            if (nums1HashMap.containsKey(integer)){

                Integer value =nums1HashMap.get(integer);
                nums1HashMap.put(integer, value+1);
            }
            else{
                nums1HashMap.put(integer, 1);
            }
        }

        ArrayList<Integer> tempResult = new ArrayList<Integer>();

        for (int integer : nums2){
            if (nums1HashMap.containsKey(integer)){
                Integer value = nums1HashMap.get(integer);
                if (value >1){
                    tempResult.add(integer);
                    nums1HashMap.put(integer, value-1);
                }
                else if (value == 1){
                    tempResult.add(integer);
                    nums1HashMap.remove(integer);
                }
            }
        }
        if (tempResult.size() == 0){
            return new int[0];
        }
        else{
            int[] toReturn = new int[tempResult.size()];

            for(int i =0;i < toReturn.length;i++){
                toReturn[i] = tempResult.get(i);
            }

            return toReturn;
        }
    }
}