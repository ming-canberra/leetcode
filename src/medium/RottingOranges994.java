package medium;

import java.util.ArrayList;
import java.util.List;

public class RottingOranges994 {
    public static void main(String[] args) {
        RottingOranges994 thisClass = new RottingOranges994();
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
}