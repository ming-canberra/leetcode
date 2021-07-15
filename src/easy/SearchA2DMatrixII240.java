package easy;

public class SearchA2DMatrixII240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        for (int i = 0; i < m; i++){
            boolean result = search(matrix[i], target);
            if (result){
                return true;
            }
        }
        return false;
    }
    private boolean search(int[] array, int target){
        int n = array.length;
        int l = -1;
        int r = n;
        while(l + 1 < r){
            int middle = l + (r - l) / 2;
            if (array[middle] == target){
                return true;
            }
            else if (array[middle] > target){
                r = middle;
            }
            else{
                l = middle;
            }
        }

        return false;
    }
}