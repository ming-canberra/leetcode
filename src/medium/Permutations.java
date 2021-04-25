package medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Permutations thisClass = new Permutations();
        System.out.println (thisClass.permute(null));
    }
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
}