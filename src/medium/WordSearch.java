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
                    && traversed[rIndex][cIndex] == false
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
}