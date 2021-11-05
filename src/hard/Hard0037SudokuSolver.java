package hard;

import java.util.*;

public class Hard0037SudokuSolver {

    class Solution {
        public void solveSudoku(char[][] board) {
            solve(board);
        }
        private boolean solve(char[][] board){
            for (int i = 0; i < 9; i++){
                for (int j = 0; j < 9; j++){
                    if (board[i][j] == '.'){
                        for (int c = 0; c < 9; c++){
                            if ( boxValid(board, i, j, c) && rowValid(board, i, c) && colValid(board, j, c) ){
                                board[i][j] = (char)('1' + c);
                                if (solve(board)){
                                    return true;
                                }
                                board[i][j] = '.';
                            }
                        }
                        return false;
                    }
                }
            }
            return true;
        }
        private boolean boxValid(char[][] board, int rIdx, int cIdx, int c){
            boolean result = true;
            for (int i = rIdx / 3 * 3; i < rIdx / 3 * 3 + 3; i++){
                for (int j = cIdx / 3 * 3; j < cIdx / 3 * 3 + 3; j++){
                    if (board[i][j] == '1' + c){
                        return false;
                    }
                }
            }
            return result;
        }
        private boolean rowValid(char[][] board, int rIdx, int c){
            boolean result = true;
            for (int i = 0; i < 9; i++){
                if (board[rIdx][i] == '1' + c)
                {
                    return false;
                }
            }
            return result;
        }
        private boolean colValid(char[][] board, int cIdx, int c){
            boolean result = true;
            for (int i = 0; i < 9; i++){
                if (board[i][cIdx] == '1' + c)
                {
                    return false;
                }
            }
            return result;
        }
    }


}