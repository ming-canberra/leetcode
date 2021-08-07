package medium;

import java.util.*;

public class FourSum18 {
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            int n = nums.length;
            if (n < 4){
                return result;
            }
            Arrays.sort(nums);
            for (int i = 0; i < n - 3; i++){
                if (i != 0 && nums[i] == nums[i - 1]){
                    continue;
                }
                // 3 sum
                for (int j = i + 1; j < n - 2; j++){
                    if (j != i + 1 && nums[j] == nums[j - 1]){
                        continue;
                    }
                    int curTarget = target - nums[i] - nums[j];
                    int l = j + 1;
                    int r = n - 1;

                    while(l < r){
                        if (nums[l] + nums[r] < curTarget){
                            l++;
                        }
                        else if (nums[l] + nums[r] > curTarget){
                            r--;
                        }
                        else{
                            result.add(Arrays.asList(new Integer[]{nums[i], nums[j], nums[l], nums[r]}));
                            l++;
                            while(l < r && nums[l - 1] == nums[l]){
                                l++;
                            }
                        }
                    }
                }
            }
            return result;
        }
    }
}