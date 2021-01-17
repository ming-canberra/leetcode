package easy;

public class ReshapetheMatrix566 {
    public static void main(String[] args) {
        ReshapetheMatrix566 thisClass = new ReshapetheMatrix566();

        int nums[][] = new int[2][2];
        nums[0] [0] = 1;
        nums[0] [1] = 2;
        nums[1] [0] = 3;
        nums[1] [1] = 4;

        thisClass.matrixReshape(nums, 1,4);
    }
    public int[][] matrixReshape(int[][] nums, int r, int c) {


        if(r*c != nums.length * nums[0].length){
            return nums;
        }
        else{
            int[] tempArray = new int[r*c];

            int tempArrayIndex = 0;
            for (int i= 0; i < nums.length; i++){
                for (int j=0; j < nums[0].length; j++){
                    tempArray[tempArrayIndex] = nums[i][j];
                    tempArrayIndex++;
                }
            }

            for (int i= 0; i < tempArray.length; i++){
                System.out.println(tempArray[i]);
            }

            tempArrayIndex = 0;
            int[][] toReturn = new int[r][c];
            for (int i= 0; i < toReturn.length; i++){
                for (int j=0; j < toReturn[i].length; j++){
                    toReturn[i][j] = tempArray[tempArrayIndex];
                    tempArrayIndex++;
                }
            }
            return toReturn;
        }
    }
}