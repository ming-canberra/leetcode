package medium;

import java.util.*;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> input = new ArrayList<Integer>();
        for (int iValue : nums){
            input.add(iValue);
        }
        List<List<Integer>>result = new ArrayList<List<Integer>>();
        permutation(input, new ArrayList<Integer>(), result);
        return result;
    }

    private void permutation(List<Integer> nums, List<Integer> tempResult, List<List<Integer>> result){
        if (nums.size() == 0){
            result.add(new ArrayList<Integer>(tempResult));
        }
        else{
            for (int i = 0; i < nums.size(); i++){
                Integer temp = nums.remove(i);
                tempResult.add(temp);
                permutation(nums, tempResult, result);
                tempResult.remove(tempResult.size() - 1);
                nums.add(i, temp);
            }
        }
    }


    class Solution {
        List<List<Integer>> result = null;
        public List<List<Integer>> permute(int[] nums) {
            result = new ArrayList<>();
            dfs(nums, nums.length, new ArrayList<>());
            return result;
        }
        private void dfs(int[] nums, int count, List<Integer> list){
            if (count == 0){
                result.add(new ArrayList<>(list));
            }

            for (int i = 0; i < nums.length; i++){
                // only add this item if it does not exist in list already
                boolean addThis = true;
                for (int itemValue : list){
                    if (itemValue == nums[i]){
                        addThis = false;
                        break;
                    }
                }
                if (addThis){
                    list.add(nums[i]);
                    dfs(nums, count - 1, list);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}