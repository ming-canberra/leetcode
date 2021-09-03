package medium;

public class SurroundedRegions130 {
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
}