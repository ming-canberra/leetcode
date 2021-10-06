package medium;
import java.util.*;

public class Hard0052NQueensII {
    class Solution {
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diag1 = new HashSet<>();
        Set<Integer> diag2 = new HashSet<>();
        int result = 0;
        public int totalNQueens(int n) {
            dfs(0, n);
            return result;
        }
        private void dfs(int row, int total){
            if (row == total){
                result++;
                return;
            }
            for (int i = 0; i < total; i++){
                if (columns.contains(i) || diag1.contains(row + i) || diag2.contains(row - i)){
                    continue;
                }
                columns.add(i);
                diag1.add(row + i);
                diag2.add(row - i);
                dfs(row + 1, total);
                columns.remove(i);
                diag1.remove(row + i);
                diag2.remove(row - i);
            }
        }
    }
}