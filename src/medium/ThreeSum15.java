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

    class Solution1 {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            if (nums.length < 3){
                return result;
            }
            for (int i = 0; i < nums.length - 2; i++){
                if (i != 0 && nums[i] == nums[i - 1]){
                    continue;
                }
                Set<Integer> set = new HashSet<>();
                for (int j = i + 1; j < nums.length; j++){
                    if (set.contains(-nums[j] - nums[i])){
                        result.add(Arrays.asList(new Integer[]{nums[i], nums[j], - nums[i] - nums[j]}));
                        while(j + 1 < nums.length && nums[j] == nums[j + 1]){
                            j++;
                        }
                    }
                    set.add(nums[j]);
                }
            }
            return result;
        }
    }
}