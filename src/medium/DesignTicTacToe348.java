package medium;

public class DesignTicTacToe348 {
    public static void main(String[] args) {
        DesignTicTacToe348 thisClass = new DesignTicTacToe348();
    }

    class TicTacToe {

        /** Initialize your data structure here. */
        int[][] mem;
        int n;
        public TicTacToe(int n) {
            this.n = n;
            mem = new int[2*n + 2][2];
        }
        /** Player {player} makes a move at ({row}, {col}).
         @param row The row of the board.
         @param col The column of the board.
         @param player The player, can be either 1 or 2.
         @return The current winning condition, can be either:
         0: No one wins.
         1: Player 1 wins.
         2: Player 2 wins. */
        public int move(int row, int col, int player) {

            if (++mem[row][player - 1] == n) {
                return player;
            }

            if (++mem[col + n][player - 1] == n) {
                return player;
            }

            if (row == col) {
                if (++mem[2 * n][player - 1] == n) {
                    return player;
                }
            }
            if (row + col == n - 1) {
                if (++mem[2 * n + 1][player - 1] == n) {
                    return player;
                }
            }

            return 0;
        }
    }

    class TicTacToe1 {
        private int length;
        private int[] rowSum;
        private int[] colSum;
        private int slashSum = 0 ;
        private int backSlashSum = 0;

        public TicTacToe1(int n) {
            rowSum = new int[n];
            colSum = new int[n];
            length = n;
        }

        /** Player {player} makes a move at ({row}, {col}).
         @param row The row of the board.
         @param col The column of the board.
         @param player The player, can be either 1 or 2.
         @return The current winning condition, can be either:
         0: No one wins.
         1: Player 1 wins.
         2: Player 2 wins. */
        public int move(int row, int col, int player) {
            if (player == 1){
                rowSum[row]++;
                colSum[col]++;
                if (row == col){
                    backSlashSum++;
                }
                if (row + col == length - 1){
                    slashSum++;
                }
                if (rowSum[row] == length || colSum[col] == length || backSlashSum == length || slashSum == length){
                    return 1;
                }
            }
            else{
                rowSum[row]--;
                colSum[col]--;
                if (row == col){
                    backSlashSum--;
                }
                if (row + col == length - 1){
                    slashSum--;
                }
                if (rowSum[row] == -length || colSum[col] == -length || backSlashSum == -length || slashSum == -length){
                    return 2;
                }
            }
            return 0;
        }
    }
}