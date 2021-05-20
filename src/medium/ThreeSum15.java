package medium;

import java.util.*;

public class ThreeSum15 {
    public static void main(String[] args) {
        ThreeSum15 thisClass = new ThreeSum15();
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        Integer lastI = null;
        for (int i = 0; i < length - 2; i++){
            if (lastI != null && lastI == nums[i]){
                continue;
            }
            int l = i + 1;
            int r = length - 1;
            Integer lastL = null;
            while (l < r){
                int sum = nums[l] + nums[r];
                if (sum > -nums[i]){
                    r--;
                }
                else if (sum < -nums[i]){
                    l++;
                }
                else{
                    if (lastL != null && lastL == nums[l]){
                        l++;
                        continue;
                    }
                    List<Integer> tmpResult = new ArrayList<>();
                    tmpResult.add(nums[i]);
                    tmpResult.add(nums[l]);
                    tmpResult.add(nums[r]);
                    result.add(tmpResult);
                    lastL = nums[l];
                    l++;
                }
            }
            lastI = nums[i];
        }
        return result;
    }
}