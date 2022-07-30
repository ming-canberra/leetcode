package medium;

import java.util.*;

public class Medium0994RottingOranges {
    public static void main(String[] args) {
        Medium0994RottingOranges thisClass = new Medium0994RottingOranges();
    }
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] array = new int[m + 2][n + 2];

        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                array[i][j] = grid[i - 1][j - 1];
            }
        }

        List<int[]> rottenPositions = new ArrayList<int[]>();

        int minute = 0;
        while(true)
        {
            boolean hasFresh = false;
            rottenPositions.clear();

            for (int i = 1; i <= m; i++)
            {
                for (int j = 1; j <= n; j++)
                {
                    if(array[i][j] == 1)
                    {
                        hasFresh = true;
                        if(array[i + 1][j] == 2
                                || array[i - 1][j] == 2
                                || array[i][j + 1] == 2
                                || array[i][j - 1] == 2)
                        {
                            rottenPositions.add(new int[]{i, j});
                        }
                    }
                }
            }

            minute++;

            if (rottenPositions.size() == 0)
            {
                if (hasFresh)
                {
                    return -1;
                }
                minute--;
                break;
            }
            else
            {
                for (int[] p : rottenPositions)
                {
                    array[p[0]][p[1]] = 2;
                }
            }
        }

        return minute;
    }

    class Solution {
        int freshCount = 0;
        int result = 0;
        public int orangesRotting(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            Queue<int[]> queue = new LinkedList<>();
            boolean[][] isFresh = new boolean[m][n];
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    if (grid[i][j] == 1){
                        freshCount++;
                        isFresh[i][j] = true;
                    }
                    else if (grid[i][j] == 2){
                        queue.add(new int[]{i, j});
                    }
                }
            }
            if (freshCount == 0){
                return 0;
            }
            while(!queue.isEmpty()){
                int size = queue.size();
                for (int i = 0; i < size; i++){
                    int[] top = queue.poll();
                    checkNeighbours(queue, isFresh, top[0] + 1, top[1], m, n);
                    checkNeighbours(queue, isFresh, top[0] - 1, top[1], m, n);
                    checkNeighbours(queue, isFresh, top[0], top[1] + 1, m, n);
                    checkNeighbours(queue, isFresh, top[0], top[1] - 1, m, n);
                }
                result++;
                if (freshCount == 0){
                    return result;
                }
            }
            return -1;
        }

        private void checkNeighbours(Queue<int[]> queue, boolean[][] isFresh, int i, int j, int m, int n){
            if (i >= 0 && i < m && j >=0 && j < n){
                if (isFresh[i][j]){
                    isFresh[i][j] = false;
                    queue.add(new int[]{i, j});
                    freshCount--;
                }
            }
        }
    }

    class Solution3 {
        public int orangesRotting(int[][] grid) {
            //0 empty
            //1 fresh
            //2 rotten
            int m = grid.length;
            int n = grid[0].length;

            int res = 0;

            Queue<int[]> queue = new LinkedList<>();
            // init the queue with rotten orange positions
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++){
                    if (grid[i][j] == 2) {
                        queue.add(new int[]{i, j});
                    }
                }
            }

            int[][] dirs = new int[][]{ new int[]{-1, 0},  new int[]{1, 0}, new int[]{0, -1}, new int[]{0, 1} };

            while( !queue.isEmpty()) {
                boolean hasFoundFresh = false;
                for (int size = queue.size(); size > 0; size--) {
                    int[] top = queue.poll();
                    // check ther neighbors of current rotten orange
                    for (int i = 0; i < 4; i++) {
                        int newR = top[0] + dirs[i][0];
                        int newC = top[1] + dirs[i][1];

                        if (newR >= 0 && newR < m && newC >= 0 && newC < n) {
                            if (grid[newR][newC] == 1) {
                                grid[newR][newC] = 2;
                                queue.add(new int[]{newR, newC});
                                hasFoundFresh = true;
                            }
                        }
                    }
                }
                if (hasFoundFresh) {
                    res++;
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++){
                    if (grid[i][j] == 1) {
                        return -1;
                    }
                }
            }

            return res;
        }
    }
}