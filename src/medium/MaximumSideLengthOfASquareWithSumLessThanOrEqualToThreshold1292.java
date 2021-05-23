package medium;

public class MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold1292 {
    public static void main(String[] args) {
        MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold1292 thisClass = new MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold1292();
    }
    /**
     *O(m*n*log(min(m, n))
     */
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                sum[1 + i][1 + j] = sum[i][j + 1] + sum[i + 1][j] - sum[i][j] + mat[i][j];
            }
        }
        int l = -1;
        int r = Math.min(m, n) + 1;
        while(l + 1 < r)
        {
            int middle = l + (r - l) / 2;
            if (squareEligible(sum, threshold, middle)){
                l = middle;
            }
            else{
                r = middle;
            }
        }
        return l;
    }
    private boolean squareEligible(int[][] sum, int threshold, int sideLength){
        for (int i = sideLength; i < sum.length; i++){
            for (int j = sideLength; j < sum[0].length; j++){
                int squareSum = sum[i][j] + sum[i - sideLength][j - sideLength] - sum[i - sideLength][j] - sum[i][j - sideLength];
                if (squareSum <= threshold){
                    return true;
                }
            }
        }
        return false;
    }
}