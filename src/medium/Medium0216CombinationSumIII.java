package medium;

import java.util.*;

public class Medium0216CombinationSumIII {
    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        public List<List<Integer>> combinationSum3(int k, int n) {
            dfs(n, 1, new ArrayList<>(), 0, k);
            return result;
        }
        private void dfs(int target, int curNum, List<Integer> list, int sum, int k){
            if (list.size() == k){
                if (target == sum){
                    result.add(new ArrayList<>(list));
                }
                return;
            }
            if (target <= sum){
                return;
            }
            if (curNum + sum > target){
                return;
            }
            for (int i = curNum; i < 10; i++){
                list.add(i);
                dfs(target, i + 1, list, sum + i, k);
                list.remove(list.size() - 1);
            }
        }
    }
}