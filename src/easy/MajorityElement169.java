package easy;

import java.util.HashMap;

public class MajorityElement169 {
    public static void main(String[] args) {
        MajorityElement169 thisClass = new MajorityElement169();

        int[] nums = new int[]{1,2,1,2,1};
        thisClass.majorityElement(nums);

    }
    public int majorityElement(int[] nums) {
        Integer maxE = null;

        HashMap<Integer, Integer> theMap = new HashMap<Integer, Integer>();

        for (int i=0;i< nums.length; i++){

            if (maxE == null){
                maxE = nums[i];
            }

            if (theMap.containsKey(nums[i])){

                int currentCount = theMap.get(nums[i]) + 1;
                if (theMap.get(maxE) < currentCount){
                    maxE = nums[i];
                }
                theMap.put(nums[i], currentCount);
            }
            else{
                theMap.put(nums[i], 1);
            }

            if (theMap.get(maxE)> nums.length/2)
                return maxE;
        }

        return 1;
    }
}