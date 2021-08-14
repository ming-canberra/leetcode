package medium;

import java.util.*;

public class Subsets78 {

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

    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(Arrays.asList(new Integer[]{nums[0]}));
            result.add(new ArrayList<Integer>());
            bfs(result, nums, 1);
            return result;
        }
        private void bfs(List<List<Integer>> result, int[] nums, int index){
            if (index < nums.length){
                int size = result.size();
                for (int i = 0; i < size; i++){
                    List<Integer> newList = new ArrayList<Integer>();
                    newList.addAll(result.get(i));
                    newList.add(nums[index]);
                    result.add(newList);
                }
                index++;
                bfs(result, nums, index);
            }
        }
    }

    class SolutionDFS {
        List<List<Integer>> result;
        public List<List<Integer>> subsets(int[] nums) {
            result = new ArrayList<List<Integer>>();
            List<Integer> tmp = new ArrayList<Integer>();
            dfs(nums, 0, tmp);
            return result;
        }
        private void dfs(int[] nums, int i, List<Integer> list){
            if(i == nums.length){
                result.add(new ArrayList<Integer>(list));
                return;
            }
            dfs(nums, i + 1, list);
            list.add(nums[i]);
            dfs(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
    class SolutionIterativeBFS {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            Queue<List<Integer>> queue = new LinkedList<>();
            queue.add(new ArrayList<Integer>());
            for(int i = 0; i < nums.length; i++){
                int size = queue.size();
                for (int j = 0; j < size; j++){
                    List<Integer> top = queue.poll();
                    queue.add(new ArrayList<Integer>(top));
                    top.add(nums[i]);
                    queue.add(top);
                }
            }

            while(!queue.isEmpty()){
                result.add( queue.poll()  ) ;
            }

            return result;
        }
    }

    class SolutionBacktrack {
        List<List<Integer>> result;
        public List<List<Integer>> subsets(int[] nums) {
            result = new ArrayList<>();
            dfs(nums, 0, new ArrayList<>());
            return result;
        }
        private void dfs(int[] nums, int index, List<Integer> list){
            if (index == nums.length){
                result.add(new ArrayList<>(list));
            }
            else{
                dfs(nums, index + 1, list);
                list.add(nums[index]);
                dfs(nums, index + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }

    class Solution1 {
        List<List<Integer>> result = new ArrayList<>();
        public List<List<Integer>> subsets(int[] nums) {
            dfs(nums, 0, new ArrayList<>());
            return result;
        }
        private void dfs(int[] nums, int index, List<Integer> list){
            if (index == nums.length){
                result.add(new ArrayList<>(list));
            }
            else{
                dfs(nums, index + 1, list);
                list.add(nums[index]);
                dfs(nums, index + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }
}