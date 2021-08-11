package medium;

import java.util.*;

public class CombinationSumII40 {
    class Solution {
        List<List<Integer>> result;
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            result = new ArrayList<>();
            Arrays.sort(candidates);
            dfs(candidates, target, new ArrayList<>(), 0, 0, new boolean[candidates.length]);
            return result;
        }
        private void dfs(int[] candidates, int target, List<Integer> list, int index, int sum, boolean[] used) {
            if(sum == target){
                result.add(new ArrayList<>(list));
            }
            else if (sum > target){
                return;
            }
            else{
                for (int i = index; i < candidates.length; i++){
                    if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]){
                        continue;
                    }
                    list.add(candidates[i]);
                    used[i] = true;
                    dfs(candidates, target, list, i + 1, sum + candidates[i], used);
                    used[i] = false;
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    class Solution1 {
        List<List<Integer>> result = new ArrayList<>();
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            dfs(candidates, target, new ArrayList<>(), 0);
            return result;
        }
        private void dfs(int[] candidates, int target, List<Integer> list, int index) {
            if (target == 0){
                result.add(new ArrayList<>(list));
            }
            else if (target > 0){
                for (int i = index; i < candidates.length; i++){
                    if (index == i || candidates[i - 1] != candidates[i]){
                        list.add(candidates[i]);
                        dfs(candidates, target - candidates[i], list, i + 1);
                        list.remove(list.size() - 1);
                    }
                }
            }
        }
    }
}