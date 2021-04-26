package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordSearchII212 {
    public static void main(String[] args) {
        WordSearchII212 thisClass = new WordSearchII212();
        List<String> res = thisClass.findWords(
                new char[][]{new char[]{'A','B'}, new char[]{'C','D'}}, new String[]{"ABDC", "f"});
        System.out.println(res);
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<String>();

        HashMap<Character, List<int[]>> charPosition = new HashMap<Character, List<int[]>>();
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                char c = board[i][j];
                if (charPosition.containsKey(c)){
                    charPosition.get(c).add(new int[]{i, j});
                }
                else{
                    List<int[]> value = new ArrayList<int[]>();
                    value.add(new int[]{i, j});
                    charPosition.put(c, value);
                }
            }
        }

        for (String word : words){
            if (wordFound(board, word, charPosition)){
                result.add(word);
            }
        }
        return result;
    }

    private boolean wordFound(char[][] board, String word, HashMap<Character, List<int[]>> charPosition){
        if (charPosition.containsKey(word.charAt(0))){
            for (int[] startPosition : charPosition.get(word.charAt(0))){
                boolean[][] charsVisited = new boolean[board.length][board[0].length];
                if (wordFound(startPosition[0], startPosition[1], board, word, 0, charsVisited)){
                    return true;
                }
            }
        }

        return false;
    }
    private boolean wordFound(int i, int j, char[][] board, String word, int currenIndex, boolean[][] charsVisited){
        if (currenIndex == word.length()){
            return true;
        }
        if (i >= 0 && j >=0
        && i < board.length && j < board[0].length
        && board[i][j] == word.charAt(currenIndex)
        && !charsVisited[i][j])
        {
            charsVisited[i][j] = true;
            if (wordFound(i, j + 1, board, word, currenIndex + 1, charsVisited))
            {
                return true;
            }
            if (wordFound(i, j - 1, board, word, currenIndex + 1, charsVisited))
            {
                return true;
            }
            if (wordFound(i + 1, j, board, word, currenIndex + 1, charsVisited))
            {
                return true;
            }
            if (wordFound(i - 1, j, board, word, currenIndex + 1, charsVisited))
            {
                return true;
            }
            charsVisited[i][j] = false;
        }
        return false;
    }


}
