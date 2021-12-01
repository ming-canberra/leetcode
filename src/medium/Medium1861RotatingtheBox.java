package medium;

public class Medium1861RotatingtheBox {
    class Solution {
        public char[][] rotateTheBox(char[][] box) {
            //# stone
            //. empty
            //* obstacle
            int m = box.length;
            int n = box[0].length;
            for (int i = 0; i < box.length; i++){
                Integer emptyIdx = null; // the first empty cell where a stone can drop to
                for (int j = n - 1; j >= 0; j--){
                    if (box[i][j] == '#'){
                        if (emptyIdx != null){
                            // set current cell empty
                            box[i][j] = '.';
                            // fill that empty cell
                            box[i][emptyIdx] = '#';
                            // move emptyIdx to left until it sees empty cell
                            while(box[i][emptyIdx] != '.'){
                                emptyIdx--;
                            }
                        }
                    }
                    else if (box[i][j] == '.'){
                        if (emptyIdx == null){
                            emptyIdx = j;
                        }
                    }
                    else if (box[i][j] == '*'){
                        emptyIdx = null;
                    }
                }
            }
            char[][] result = rotate(box);
            return result;
        }
        private char[][] rotate(char[][] box){
            int m = box.length;
            int n = box[0].length;
            char[][] result = new char[n][m];
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    result[j][m - 1 - i ] = box[i][j];
                }
            }
            return result;
        }
    }

}