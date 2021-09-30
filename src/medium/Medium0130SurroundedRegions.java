package medium;

import java.util.*;

public class Medium0130SurroundedRegions {
    int m;
    int n;
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                dfs(board, i, j, false);
            }
        }
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (board[i][j] == 'M'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    private void dfs(char[][] board, int i, int j, boolean forceMarkM){
        if (i < 0 || i >= m || j < 0 || j >= n){
            return;
        }
        if (board[i][j] == 'M' || board[i][j] == 'X'){
            return;
        }
        if (i == 0 || j == 0 || i == m - 1 || j == n - 1 || forceMarkM){
            board[i][j] = 'M';
            dfs(board, i - 1, j, true);
            dfs(board, i + 1, j, true);
            dfs(board, i, j - 1, true);
            dfs(board, i, j + 1, true);
        }
    }

    class Solution {
        int[][] dirs = new int[][]{new int[]{-1, 0}, new int[]{1, 0}, new int[]{0, 1}, new int[]{0, -1}};
        int m;
        int n;
        public void solve(char[][] board) {
            m = board.length;
            n = board[0].length;
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    bfs(board, i, j);
                }
            }
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    if (board[i][j] == 'O'){
                        board[i][j] = 'X';
                    }
                    if (board[i][j] == '1'){
                        board[i][j] = 'O';
                    }
                }
            }
        }
        private void bfs(char[][] board, int rIndex, int cIndex){
            if (board[rIndex][cIndex] == 'X' || board[rIndex][cIndex] == '1'){
                return;
            }
            if (rIndex == 0 || rIndex == m - 1 || cIndex == 0 || cIndex == n - 1){
                Queue<Integer> queue = new LinkedList<>();
                queue.add(rIndex * n + cIndex);
                while(!queue.isEmpty()){
                    Set<Integer> set = new HashSet<>();
                    for (int size = queue.size(); size > 0; size--){
                        int top = queue.poll();
                        board[top / n][top % n] = '1';
                        for (int i = 0; i < dirs.length; i++){
                            int rIndexNew = top / n + dirs[i][0];
                            int cIndexNew = top % n + dirs[i][1];
                            if (rIndexNew >= 0 && rIndexNew < m && cIndexNew >= 0 && cIndexNew < n && board[rIndexNew][cIndexNew] == 'O'){
                                set.add(rIndexNew * n + cIndexNew);
                            }
                        }
                    }
                    queue.addAll(set);
                }
            }
        }
    }
}