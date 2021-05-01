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
            mem[row][player - 1]++;
            mem[col + n][player - 1]++;
            if (row == col){
                mem[2 * n][player - 1]++;
            }
            if (row + col == n - 1){
                mem[2 * n + 1][player - 1]++;
            }

            for (int i = 0; i < mem.length; i++){
                if (mem[i][player - 1] == n)
                {
                    return player;
                }
            }
            return 0;
        }




    }
}