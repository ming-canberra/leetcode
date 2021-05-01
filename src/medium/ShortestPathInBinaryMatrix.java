package medium;

import java.util.*;

public class ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        ShortestPathInBinaryMatrix thisClass = new ShortestPathInBinaryMatrix();



        int res = thisClass.shortestPathBinaryMatrix(new int[][]{new int[]{1}});
        System.out.println(res);
    }
    private int[][] dir = new int[][]{new int[]{-1, 0}, new int[]{-1, 1}, new int[]{-1, -1}, new int[]{1, 1},
            new int[]{1, 0}, new int[]{1, -1}, new int[]{0, -1}, new int[]{0, 1}};

    public int shortestPathBinaryMatrix(int[][] grid)
    {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
        {
            return -1;
        }

        if (n == 1)
        {
            return 1;
        }

        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[]{0, 0});
        grid[0][0] = 1;
        while (!q.isEmpty())
        {
            int[] cur = q.poll();

            int distance = grid[cur[0]][cur[1]];

            List<int[]> neighbours = getNeighbours(cur[0], cur[1], grid);
            for (int[] node : neighbours)
            {
                if (node[0] == n -1 && node[1] == n - 1)
                {
                    return distance + 1;
                }
                grid[node[0]][node[1]] = distance + 1;
                q.add(node);
            }
        }
        return -1;
    }

    private List<int[]> getNeighbours(int r, int c, int[][] grid)
    {
        List<int[]> result = new ArrayList<int[]>();
        for (int i = 0; i < dir.length; i++)
        {
            if (r + dir[i][0] >=0 && r + dir[i][0] < grid.length)
            {
                if (c + dir[i][1] >=0 && c + dir[i][1] < grid.length)
                {
                    if (grid[r + dir[i][0]][c + dir[i][1]] == 0)
                    {
                        result.add(new int[]{r + dir[i][0], c + dir[i][1]});
                    }
                }
            }
        }
        return result;
    }
}