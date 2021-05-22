package medium;

public class SearchA2DMatrix74 {
    public static void main(String[] args) {
        SearchA2DMatrix74 thisClass = new SearchA2DMatrix74();
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length * matrix[0].length;
        int l = -1;
        int r = n;
        while (l + 1 < r){
            int m = l + (r - l) / 2;
            int mValue = getMatrixValue(matrix, m);
            if (mValue == target){
                return true;
            }
            else if (mValue < target){
                l = m;
            }
            else{
                r = m;
            }
        }
        return false;
    }
    private int getMatrixValue(int[][] matrix, int m){
        int colLength = matrix[0].length;
        int i = m / colLength;
        int j = m % colLength;
        return matrix[i][j];
    }
}