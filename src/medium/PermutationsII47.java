package medium;

import java.util.*;

public class PermutationsII47 {
    class Solution {
        List<List<Integer>> result;
        public List<List<Integer>> permuteUnique(int[] nums) {
            result = new ArrayList<>();
            Arrays.sort(nums);
            dfs(nums, new ArrayList<>(), new boolean[nums.length]);
            return result;
        }
        private void dfs(int[] nums, List<Integer> list, boolean[] used){
            if (list.size() == nums.length){
                result.add(new ArrayList<>(list));
            }
            else{
                for (int i = 0; i < nums.length; i++){
                    if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                        continue;
                    }
                    if(!used[i]){
                        used[i] = true;
                        list.add(nums[i]);
                        dfs(nums, list, used);
                        list.remove(list.size() - 1);
                        used[i] = false;
                    }
                }
            }
        }
    }
}