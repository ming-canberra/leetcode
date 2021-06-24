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

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {

            int n = nums.length;
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<List<Integer>>();

            if (n < 3){
                return result;
            }

            for (int i = 0; i < n - 2; i++){
                int iVal = nums[i];
                if ( i > 0 ){
                    if(nums[i] == nums[i - 1]){
                        continue;
                    }
                }

                int l = i + 1;
                int r = n - 1;

                while(l < r){
                    int lVal = nums[l];
                    int rVal = nums[r];

                    if (lVal + rVal == -iVal){
                        result.add(Arrays.asList(iVal, lVal, rVal));
                        l++;
                        while((nums[l] == nums[l - 1]) && (l < r)) {
                            l++;
                        }
                    }
                    else if (lVal + rVal < -iVal){
                        l++;
                    }
                    else{
                        r--;
                    }
                }
            }

            return result;
        }
    }
}