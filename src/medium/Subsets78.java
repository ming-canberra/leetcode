package medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets78 {
    public static void main(String[] args) {
        Subsets78 thisClass = new Subsets78();
        System.out.println (thisClass.subsets(null));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        generateSub(result, nums, 0, new ArrayList<Integer>());
        return result;
    }

    private void generateSub(List<List<Integer>> result, int[] nums, int sIndex, List<Integer> tResult) {
        for (int i = sIndex; i < nums.length; i++) {
            tResult.add(nums[i]);
            result.add(new ArrayList<>(tResult));
            generateSub(result, nums, i + 1, tResult);
            tResult.remove(tResult.size() - 1);
        }
    }
}