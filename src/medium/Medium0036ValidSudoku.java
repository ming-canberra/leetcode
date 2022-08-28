package medium;

import java.util.*;

public class Medium0036ValidSudoku {
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            List<Character> list = Arrays.asList(new Character[]{'1','2','3','4','5','6','7','8','9'});
            for (int i = 0; i < 9; i++){
                char[] input = new char[]{board[i][0], board[i][1], board[i][2], board[i][3],
                        board[i][4], board[i][5], board[i][6], board[i][7], board[i][8]};
                boolean isValid = isValid(input, new HashSet<>(list));
                if (!isValid){
                    return false;
                }
            }
            for (int i = 0; i < 9; i++){
                char[] input = new char[]{board[0][i], board[1][i], board[2][i], board[3][i],
                        board[4][i], board[5][i], board[6][i], board[7][i], board[8][i]};
                boolean isValid = isValid(input, new HashSet<>(list));
                if (!isValid){
                    return false;
                }
            }
            int[][] startingPositions = new int[][]{new int[]{0, 0}, new int[]{0, 3}, new int[]{0, 6},
                    new int[]{3, 0}, new int[]{3, 3}, new int[]{3, 6},
                    new int[]{6, 0}, new int[]{6, 3}, new int[]{6, 6} };
            for (int[] item : startingPositions){
                boolean result = isMatrixValid(item[0], item[1], board, new HashSet<>(list));
                if (!result){
                    return false;
                }
            }
            return true;
        }
        private boolean isMatrixValid(int rIndex, int cIndex, char[][] board, Set<Character> set){
            char[] input = new char[]{board[rIndex][cIndex], board[rIndex][cIndex + 1], board[rIndex][cIndex + 2],
                    board[rIndex + 1][cIndex], board[rIndex + 1][cIndex + 1], board[rIndex + 1][cIndex + 2],
                    board[rIndex + 2][cIndex], board[rIndex + 2][cIndex + 1], board[rIndex + 2][cIndex + 2]};

            return isValid(input, set);
        }
        private boolean isValid(char[] board, Set<Character> set){
            for (char c : board){
                if (c != '.'){
                    if (set.contains(c)){
                        set.remove(c);
                    }
                    else{
                        return false;
                    }
                }
            }
            return true;
        }
    }

    class Solution1 {
        public boolean isValidSudoku(char[][] board) {
            for (int i = 0; i < 9; i++){
                if (!isValidRow(board, i)){
                    return false;
                }
                if (!isValidCol(board, i)){
                    return false;
                }
            }
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){
                    if (!isValidSquare(board, i * 3, j * 3)){
                        return false;
                    }
                }
            }
            return true;
        }
        private boolean isValidRow(char[][] board, int rowIndex){
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < 9; i++){
                char charValue =  board[rowIndex][i];
                if (charValue != '.'){
                    if (charValue == '0'){
                        return false;
                    }
                    else{
                        if (set.contains(charValue)){
                            return false;
                        }
                        else{
                            set.add(charValue);
                        }
                    }
                }
            }
            return true;
        }
        private boolean isValidCol(char[][] board, int colIndex){
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < 9; i++){
                char charValue =  board[i][colIndex];
                if (charValue != '.'){
                    if (charValue == '0'){
                        return false;
                    }
                    else{
                        if (set.contains(charValue)){
                            return false;
                        }
                        else{
                            set.add(charValue);
                        }
                    }
                }
            }
            return true;
        }
        private boolean isValidSquare(char[][] board, int rowDiff, int colDiff){
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){
                    char charValue =  board[i + rowDiff][j + colDiff];
                    if (charValue != '.'){
                        if (charValue == '0'){
                            return false;
                        }
                        else{
                            if (set.contains(charValue)){
                                return false;
                            }
                            else{
                                set.add(charValue);
                            }
                        }
                    }
                }
            }
            return true;
        }
    }

    class Solution2 {
        public boolean isValidSudoku(char[][] board) {
            boolean[][] rowValidator = new boolean[9][9];

            boolean[][] colValidator = new boolean[9][9];

            boolean[][] subValidator = new boolean[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '.') {
                        continue;
                    }

                    int value = board[i][j] - '1';

                    if (rowValidator[i][value]) {
                        return false;
                    }

                    if (colValidator[j][value]) {
                        return false;
                    }

                    if (subValidator[i / 3 * 3 + j / 3 ][value]) {
                        return false;
                    }
                    rowValidator[i][value] = true;
                    colValidator[j][value] = true;
                    subValidator[i / 3 * 3 + j / 3][value] = true;
                }
            }

            return true;
        }
    }
}