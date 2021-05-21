package easy;
import java.util.*;

public class CountNegativeNumbersInASortedMatrix1351 {
    public static void main(String[] args) {
        CountNegativeNumbersInASortedMatrix1351 thisClass = new CountNegativeNumbersInASortedMatrix1351();
    }

    /**
     * O(m * logn)
     * */
    class solution1{
        public int countNegatives(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int result = 0;
            for (int i = 0; i < m; i++){
                int tmp = countArray(grid[i]);
                result+=tmp;
            }
            return result;
        }
        private int countArray(int[] grid){
            int n = grid.length;
            int l = 0;
            int r = n - 1;
            while (l < r){
                int m = l + (r - l) / 2;
                if (grid[m] >= 0){
                    if (grid[m + 1] < 0)
                    {
                        return n - m - 1;
                    }
                    else{
                        l = m + 1;
                    }
                }
                else{
                    r = m;
                }
            }
            return grid[l] < 0 ? n - l : 0;
        }
    }

    /**
     * O(m + n)
     * */
    class solution2{
        public int countNegatives(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int i = 0;
            int j = n - 1;

            int result = 0;

            while(i < m && j >= 0 && j < n){
                if(grid[i][j] >= 0){
                    i++;
                }
                else if(grid[i][j] < 0){
                    if (j > 0 && grid[i][j - 1] < 0){
                        j--;
                    }
                    else{
                        result+=n - j;
                        i++;
                    }
                }
            }

            return result;
        }
    }
}