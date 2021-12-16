package medium;

import java.util.*;

public class Medium0909SnakesandLadders {
    class Solution {
        public int snakesAndLadders(int[][] board) {
            int len = board.length;
            List<Integer> boardList = new ArrayList<>();// 1 based index
            boardList.add(0);
            boolean goingForward = true;
            for (int i = len - 1; i >= 0; i--){
                if (goingForward){
                    goingForward = false;
                    for (int j = 0; j < len; j++){
                        boardList.add(board[i][j]);
                    }
                }
                else{
                    goingForward = true;
                    for (int j = len - 1; j >= 0; j--){
                        boardList.add(board[i][j]);
                    }
                }
            }
            Queue<Integer> queue = new LinkedList<>();// store lable
            queue.add(1);
            int steps = 0;
            boolean[] visited = new boolean[len * len + 1];
            while(!queue.isEmpty()){
                for (int size = queue.size(); size > 0; size--){
                    int top = queue.poll();
                    if (top == len * len){
                        return steps;
                    }
                    if (!visited[top]){
                        visited[top] = true;
                        for (int i = top + 1; i <= top + 6 && i <= len * len; i++){
                            if (boardList.get(i) == -1){
                                queue.add(i);
                            }
                            else{
                                queue.add(boardList.get(i));
                            }
                        }
                    }
                }
                steps++;
            }
            return -1;
        }
    }
}