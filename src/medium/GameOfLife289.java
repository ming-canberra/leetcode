package medium;

import java.util.*;

public class GameOfLife289 {
    class Solution {
        public void gameOfLife(int[][] board) {
            int m = board.length;
            int n = board[0].length;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    if (isLiveNextState(board, i, j, m, n)){
                        list.add(1);
                    }
                    else{
                        list.add(0);
                    }
                }
            }
            for (int i = 0; i < list.size(); i++){

                int r = i / n;
                int c = i % n;
                board[r][c] = list.get(i);
            }
        }
        private final int[][] neighbors = new int[][]{new int[]{1, 0}, new int[]{1, -1}, new int[]{1, 1}, new int[]{-1, 0},
                new int[]{-1, 1}, new int[]{-1, -1}, new int[]{0, 1}, new int[]{0, -1}};
        private boolean isLiveNextState(int[][] board, int r, int c, int m, int n){
            int countLive = 0;
            for (int i = 0; i < neighbors.length; i++){
                int[] neighbor = neighbors[i];
                int rNbr = r + neighbor[0];
                int cNbr = c + neighbor[1];
                if (rNbr >= 0 && rNbr < m && cNbr >= 0 && cNbr < n){
                    if (board[rNbr][cNbr] == 1){
                        countLive++;
                    }
                }
            }
            if (board[r][c] == 1){
                if (countLive < 2){
                    return false;
                }
                else if (countLive == 2 || countLive == 3){
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                if (countLive == 3){
                    return true;
                }
                return false;
            }
        }
    }
}