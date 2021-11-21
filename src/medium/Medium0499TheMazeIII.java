package medium;

import java.util.*;

public class Medium0499TheMazeIII {
    class Solution {
        public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
            int m = maze.length;
            int n = maze[0].length;
            boolean[][] visited = new boolean[m][n];
            PriorityQueue<Path> heap = new PriorityQueue<>( (a, b) -> a.dist == b.dist ? a.instructions.compareTo(b.instructions) : Integer.compare(a.dist, b.dist) );
            heap.add(new Path(ball[0], ball[1], "", 0));
            int[][] dirs = new int[][]{ new int[]{-1, 0}, new int[]{1, 0}, new int[]{0, 1}, new int[]{0, -1} };
            while(!heap.isEmpty()){
                Path top = heap.poll();
                int rIdx = top.rIdx;
                int cIdx = top.cIdx;
                int dist = top.dist;
                String instructions = new String(top.instructions);

                if (rIdx == hole[0] && cIdx == hole[1] ){
                    return instructions;
                }
                if (!visited[rIdx][cIdx]){
                    visited[rIdx][cIdx] = true;
                    for (int i = 0; i < dirs.length; i++){
                        int newX = rIdx;
                        int newY = cIdx;
                        int newDist = dist;
                        String newIns;
                        if (i == 0){
                            newIns = instructions + "u";
                        }
                        else if (i == 1){
                            newIns = instructions + "d";
                        }
                        else if (i == 2){
                            newIns = instructions + "r";
                        }
                        else{
                            newIns = instructions + "l";
                        }
                        while(newX >= 0 && newX < m && newY >= 0 && newY < n && maze[newX][newY] == 0 && !(newX == hole[0] && newY == hole[1]) )
                        {
                            newX += dirs[i][0];
                            newY += dirs[i][1];
                            newDist++;
                        }
                        if ((newX == hole[0] && newY == hole[1])){
                            heap.add(new Path(newX, newY, newIns, newDist));
                        }
                        else{
                            newX -= dirs[i][0];
                            newY -= dirs[i][1];
                            newDist--;
                            heap.add(new Path(newX, newY, newIns, newDist));
                        }
                    }
                }
            }
            return "impossible";
        }
        class Path{
            int rIdx;
            int cIdx;
            String instructions;
            int dist;
            public Path(int rIdx, int cIdx, String instructions, int dist){
                this.rIdx = rIdx;
                this.cIdx = cIdx;
                this.instructions = instructions;
                this.dist = dist;
            }
        }
    }
}