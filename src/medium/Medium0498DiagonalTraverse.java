package medium;

import java.util.*;

public class Medium0498DiagonalTraverse {
    class Solution {
        public int[] findDiagonalOrder(int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;
            int[] result = new int[m * n];
            int index = 0;
            int row = 0;
            int col = 0;
            boolean oneClockDirection = true;
            while(true){
                result[index++] = mat[row][col];
                if (oneClockDirection){
                    if (row - 1 < 0 || col + 1 >= n)
                    {
                        oneClockDirection = false;
                        if (col + 1 < n){
                            col++;
                        }
                        else if (row + 1 < m){
                            row++;
                        }
                        else{
                            break;
                        }
                    }
                    else{
                        row--;
                        col++;
                    }
                }
                //moving from top right to bottom left
                else{
                    if (col - 1 < 0 || row + 1 >= m)
                    {
                        oneClockDirection = true;
                        if (row + 1 < m){
                            row++;
                        }
                        else if (col + 1 < n){
                            col++;
                        }
                        else{
                            break;
                        }
                    }
                    else{
                        row++;
                        col--;
                    }
                }
            }
            return result;
        }
    }
}