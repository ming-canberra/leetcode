package medium;

public class Medium0073SetMatrixZeroes {
    class Solution {
        public void setZeroes(int[][] matrix) {
            boolean topRowHasZ = false;
            boolean leftColHasZ = false;
            int rLen = matrix.length;
            int cLen = matrix[0].length;
            for (int i = 0; i < cLen; i++){
                if (matrix[0][i] == 0){
                    topRowHasZ = true;
                    break;
                }
            }
            for (int i = 0; i < rLen; i++){
                if (matrix[i][0] == 0){
                    leftColHasZ = true;
                    break;
                }
            }
            for (int i = 1; i < rLen; i++){
                for (int j = 1; j < cLen; j++){
                    if(matrix[i][j] == 0){
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                    }
                }
            }
            for (int i = 1; i < rLen; i++){
                for (int j = 1; j < cLen; j++){
                    if(matrix[0][j] == 0 || matrix[i][0] == 0){
                        matrix[i][j] = 0;
                    }
                }
            }
            if (topRowHasZ){
                for (int i = 0; i < cLen; i++){
                    matrix[0][i] = 0;
                }
            }
            if (leftColHasZ){
                for (int i = 0; i < rLen; i++){
                    matrix[i][0] = 0;
                }
            }
        }
    }

    class Solution1 {
        public void setZeroes(int[][] matrix) {
            boolean topHasZero = false;
            boolean leftHasZero = false;
            int rCount = matrix.length;
            int cCount = matrix[0].length;
            for (int i = 0; i < rCount; i++){
                if (matrix[i][0] == 0) {
                    leftHasZero = true;
                }
            }
            for (int i = 0; i < cCount; i++){
                if (matrix[0][i] == 0) {
                    topHasZero = true;
                }
            }
            for (int i = 0; i < rCount; i++) {
                for (int j = 0; j < cCount; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
            for (int i = 1; i < rCount; i++) {
                for (int j = 1; j < cCount; j++) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
            if (topHasZero) {
                for (int i = 0; i < cCount; i++) {
                    matrix[0][i] = 0;
                }
            }
            if (leftHasZero) {
                for (int i = 0; i < rCount; i++) {
                    matrix[i][0] = 0;
                }
            }
        }
    }
}