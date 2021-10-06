package medium;
import java.util.*;

public class Hard0051NQueens {
    class Solution {
        private Set<Integer> col = new HashSet<>();
        private Set<Integer> diagonal1 = new HashSet<>();
        private Set<Integer> diagonal2 = new HashSet<>();
        private List<List<String>> result = new ArrayList<>();
        public List<List<String>> solveNQueens(int n) {
            dfs(new ArrayList<String>(), 0, n);
            return result;
        }
        private void dfs(List<String> list, int row, int n){
            if(row == n){
                result.add(new ArrayList<>(list));
                return;
            }
            // this is the column index
            for (int i = 0; i < n; i++){
                if (col.contains(i) || diagonal1.contains(row + i) || diagonal2.contains(row - i)){
                    continue;
                }
                char[] charArray = new char[n];
                Arrays.fill(charArray, '.');
                charArray[i] = 'Q';

                list.add(new String(charArray));

                col.add(i);
                diagonal1.add(row + i);
                diagonal2.add(row - i);
                dfs(list, row + 1, n);
                list.remove(list.size() - 1);
                col.remove(i);
                diagonal1.remove(row + i);
                diagonal2.remove(row - i);
            }
        }
    }
}