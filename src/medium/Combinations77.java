package medium;

import java.util.*;

public class Combinations77 {
    class Solution {
        List<List<Integer>> result;
        public List<List<Integer>> combine(int n, int k) {
            result = new ArrayList<>();
            recursiveComb(1, n, k, new ArrayList<>());
            return result;
        }
        private void recursiveComb(int start, int n, int k, List<Integer> list){
            if (k == 0){
                result.add(new ArrayList<>(list));
                return;
            }
            for (int i = start; i <= n; i++){
                list.add(i);
                recursiveComb(i + 1, n, k - 1, list);
                list.remove(list.size() - 1);
            }
        }
    }

    class Solution1 {
        List<List<Integer>> result = new ArrayList<>();
        public List<List<Integer>> combine(int n, int k) {
            dfs(n, k, 1, new ArrayList<>());
            return result;
        }
        private void dfs(int n, int k, int num, List<Integer> list){
            if (list.size() == k){
                result.add(new ArrayList<>(list));
            }
            else{
                for (int i = num; i <= n; i++){
                    list.add(i);
                    dfs(n, k, i + 1, list);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}