package medium;

import java.util.ArrayList;
import java.util.List;

public class Medium0386LexicographicalNumbers {
    class Solution {
        List<Integer> result = new ArrayList<>();
        public List<Integer> lexicalOrder(int n) {
            for (int i = 1; i < 10; i++){
                if (i <= n){
                    result.add(i);
                    dfs(i, n);
                }
            }
            return result;
        }
        private void dfs(Integer prevInt, int n){
            for (int i = 0; i < 10; i++){
                Integer curInt =  prevInt * 10 + i;
                if (curInt <= n){
                    result.add(curInt);
                    dfs(curInt, n);
                }
                else{
                    return;
                }
            }
        }
    }
}