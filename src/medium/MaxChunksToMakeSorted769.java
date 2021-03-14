package medium;

import java.util.HashSet;

public class MaxChunksToMakeSorted769 {
    public static void main(String[] args) {
        MaxChunksToMakeSorted769 thisClass = new MaxChunksToMakeSorted769();

        int res = thisClass.maxChunksToSorted(new int[]{5,4,0,3,1,6,2});
        System.out.println(res);
    }
    public int maxChunksToSorted(int[] arr) {

        int toReturn = 0;

        int currentIndex = 0;

        int i = 0;
        while (i < arr.length){
            int currentMax = 0;
            while (arr[i] != currentIndex && i < arr.length){
                currentMax = Math.max(currentMax, arr[i]);
                i++;
            }
            if (currentMax >i){
                for (int j = i+1;j<=currentMax;j++){
                    currentMax = Math.max(currentMax, arr[j]);
                }
                i = currentMax;
                currentIndex = currentMax+1;
                toReturn++;
            }
            else{
                currentIndex = i+1;
                toReturn++;
            }



            i++;
        }



        return Math.max(1, toReturn);
    }
}