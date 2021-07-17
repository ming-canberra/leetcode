package medium;

import java.util.*;

public class SubsetsII90 {
    class Solution {
        List<List<Integer>> result;
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            result = new ArrayList<>();
            Arrays.sort(nums);
            dfs(nums, new ArrayList<>(), 0, new boolean[nums.length]);
            return result;
        }
        private void dfs(int[] nums, List<Integer> list, int count, boolean[] inUse){
            if (count == nums.length){
                result.add(new ArrayList<>(list));
            }
            else{
                //not adding current element
                dfs(nums, list, count + 1, inUse);

                //bail out if the element on this layer is the same as the last layer AND last layer did not add the same lement
                if (count > 0 && nums[count] == nums[count - 1] && !inUse[count - 1]){
                    return;
                }

                //adding current element
                list.add(nums[count]);
                inUse[count] = true;
                dfs(nums, list, count + 1, inUse);
                inUse[count] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}