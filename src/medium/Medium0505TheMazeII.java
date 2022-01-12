package medium;

import java.util.*;

public class Medium0505TheMazeII {
    class Solution {
        int m, n;
        public int shortestDistance(int[][] maze, int[] start, int[] destination) {
            m = maze.length;
            n = maze[0].length;
            boolean[][] visited = new boolean[m][n];
            PriorityQueue<Pair> heap = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));
            heap.add(new Pair(start, 0));
            while(!heap.isEmpty()){
                Pair top = heap.poll();
                if (top.pos[0] == destination[0] && top.pos[1] == destination[1] ){
                    return top.dist;
                }
                if (!visited[top.pos[0]][top.pos[1]]){
                    visited[top.pos[0]][top.pos[1]] = true;
                    heap.addAll( nextStop(top.pos[0], top.pos[1], maze, top.dist) );
                }
            }
            return -1;
        }
        private List<Pair> nextStop(int rIdx, int cIdx, int[][] maze, int dist){
            int[][] dirs = new int[][]{ new int[]{-1, 0}, new int[]{1, 0}, new int[]{0, -1}, new int[]{0, 1} };
            List<Pair> list = new ArrayList<>();
            for (int i = 0; i < dirs.length; i++){
                int myDist = dist;
                int newX = rIdx;
                int newY = cIdx;
                while(newX >= 0 && newX < m && newY >= 0 && newY < n && maze[newX][newY] == 0){
                    newX += dirs[i][0];
                    newY += dirs[i][1];
                    myDist++;
                }
                newX -= dirs[i][0];
                newY -= dirs[i][1];
                myDist--;
                if (newX == rIdx && newY == cIdx){
                    continue;
                }
                list.add(new Pair( new int[]{newX, newY} , myDist));
            }
            return list;
        }
        class Pair{
            int[] pos;
            int dist;
            public Pair(int[] pInput, int distInput){
                pos = pInput;
                dist = distInput;
            }
        }
    }

    class Solution2 {
        public int shortestDistance(int[][] maze, int[] start, int[] destination) {
            int rNum = maze.length;
            int cNum = maze[0].length;

            PriorityQueue<int[]> heap = new PriorityQueue<>( (a, b) -> a[2] - b[2]);
            heap.add(new int[]{start[0], start[1], 0});
            boolean[][] visited = new boolean[rNum][cNum];

            int[][] dirs = new int[][]{new int[]{-1, 0}, new int[]{1, 0}, new int[]{0, 1}, new int[]{0, -1}};

            while(!heap.isEmpty()){
                int[] top = heap.poll();
                if (!visited[top[0]][top[1]]){
                    visited[top[0]][top[1]] = true;
                    if (top[0] == destination[0] && top[1] == destination[1]){
                        return top[2];
                    }

                    for (int k = 0; k < 4; k++){
                        int rIdx = top[0];
                        int cIdx = top[1];
                        int dis = 0;
                        while(rIdx >= 0 && rIdx < rNum && cIdx >= 0 && cIdx < cNum && maze[rIdx][cIdx] == 0){
                            rIdx += dirs[k][0];
                            cIdx += dirs[k][1];
                            dis++;
                        }
                        rIdx -= dirs[k][0];
                        cIdx -= dirs[k][1];
                        dis--;
                        if (dis != 0){
                            heap.add(new int[]{rIdx, cIdx, top[2] + dis});
                        }
                    }
                }
            }

            return -1;
        }
    }
}