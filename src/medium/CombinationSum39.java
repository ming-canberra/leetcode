package medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum39 {
    public static void main(String[] args) {
        CombinationSum39 thisClass = new CombinationSum39();
        System.out.println (thisClass.combinationSum(null, 3));
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        sum(candidates, target, result, 0, new ArrayList<Integer>(), 0);
        return result;
    }
    private void sum(int[] candidates, int target, List<List<Integer>> result, int prevSum, List<Integer> prevList,
                     int startingIndex){
        if (prevSum < target){
            for (int i = startingIndex; i < candidates.length; i++){
                prevList.add(candidates[i]);
                sum(candidates, target, result, prevSum + candidates[i], prevList, i);
                prevList.remove(prevList.size() - 1);
            }
        }
        else if (prevSum == target){
            result.add(new ArrayList<Integer>(prevList));
        }
    }

    class Solution {
        List<List<Integer>> result;
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            result = new ArrayList<>();
            dfs(candidates, target, new ArrayList<>(), 0, 0);
            return result;
        }
        private void dfs(int[] candidates, int target, List<Integer> list, int curIndex, int sum){
            if(sum == target){
                result.add(new ArrayList<>(list));
            }
            else if (sum > target){
                return;
            }
            else{
                for (int i = curIndex; i < candidates.length; i++){
                    list.add(candidates[i]);
                    dfs(candidates, target, list, i, sum + candidates[i]);
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    class Solution1 {
        private List<List<Integer>> result = new ArrayList<>();
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            dfs(candidates, target, new ArrayList<>(), 0);
            return result;
        }
        private void dfs(int[] candidates, int target, List<Integer> curList, int index) {
            if (target == 0){
                result.add(new ArrayList<>(curList));
            }
            else if(target > 0){
                for(int i = index; i < candidates.length; i++){
                    curList.add(candidates[i]);
                    dfs(candidates, target - candidates[i], curList, i);
                    curList.remove(curList.size() - 1);
                }
            }
        }
    }
}