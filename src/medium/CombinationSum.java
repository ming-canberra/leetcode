package medium;

import easy.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CombinationSum {
    public static void main(String[] args) {
        CombinationSum thisClass = new CombinationSum();
        System.out.println (thisClass.combinationSum(null, 3));
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        List<Integer> intList = new ArrayList<Integer>();
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
}