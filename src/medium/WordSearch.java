package medium;

import java.util.HashSet;

public class WordSearch {
    public static void main(String[] args) {
        WordSearch thisClass = new WordSearch();

        boolean res = thisClass.exist(
                new char[][]{new char[]{'A','B'}, new char[]{'C','D'}}, "ABDC");
        System.out.println(res);
    }
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (traverseHelper(board, word, 0, new boolean[board.length][board[0].length], i, j) )
                {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean traverseHelper(char[][] board, String word, int charIndex,
                                   boolean[][] traversed, int rIndex, int cIndex){
        if (charIndex == word.length()){
            return true;
        }
        else{
            if (rIndex < board.length && rIndex >=0
                    && cIndex < board[0].length && cIndex >= 0
                    && !traversed[rIndex][cIndex]
                    && board[rIndex][cIndex] == word.charAt(charIndex)){
                traversed[rIndex][cIndex] = true;

                boolean result1 = traverseHelper(board, word, charIndex + 1, traversed, rIndex + 1, cIndex);
                if (result1){
                    return true;
                }
                boolean result2 = traverseHelper(board, word, charIndex + 1, traversed, rIndex - 1, cIndex);
                if (result2){
                    return true;
                }
                boolean result3 = traverseHelper(board, word, charIndex + 1, traversed, rIndex, cIndex + 1);
                if (result3){
                    return true;
                }
                boolean result4 = traverseHelper(board, word, charIndex + 1, traversed, rIndex, cIndex - 1);
                if (result4){
                    return true;
                }
                traversed[rIndex][cIndex] = false;
            }
            return false;
        }
    }

    class Solution {
        public boolean exist(char[][] board, String word) {
            int m = board.length;
            int n = board[0].length;
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    boolean result = dfs(board, word, i, j, 0, new boolean[m][n]);
                    if (result){
                        return true;
                    }
                }
            }
            return false;
        }
        private boolean dfs(char[][] board, String word, int rowI, int colI, int wIndex, boolean[][] used){
            if (used[rowI][colI]){
                return false;
            }
            if (board[rowI][colI] == word.charAt(wIndex)){
                used[rowI][colI] = true;
                if (wIndex == word.length() - 1){
                    return true;
                }
                if (rowI + 1 < board.length){
                    boolean tmpResult = dfs(board, word, rowI + 1, colI, wIndex + 1, used);
                    if (tmpResult){
                        return tmpResult;
                    }
                }
                if (rowI - 1 >= 0){
                    boolean tmpResult = dfs(board, word, rowI - 1, colI, wIndex + 1, used);
                    if (tmpResult){
                        return tmpResult;
                    }
                }
                if (colI + 1 < board[0].length){
                    boolean tmpResult = dfs(board, word, rowI, colI + 1, wIndex + 1, used);
                    if (tmpResult){
                        return tmpResult;
                    }
                }
                if (colI - 1 >= 0){
                    boolean tmpResult = dfs(board, word, rowI, colI - 1, wIndex + 1, used);
                    if (tmpResult){
                        return tmpResult;
                    }
                }
                used[rowI][colI] = false;
            }
            return false;
        }
    }
}