package easy;

public class DuplicateZeros1089 {
    class Solution {
        public void duplicateZeros(int[] arr) {
            int[] tmp = new int[arr.length];

            int curIndex = 0;
            for (int i = 0; i < arr.length; i++){
                if (arr[i] == 0){
                    tmp[curIndex] = 0;
                    if (curIndex < arr.length - 1){
                        curIndex++;
                        tmp[curIndex] = 0;
                    }
                }
                else{
                    tmp[curIndex] = arr[i];
                }
                curIndex++;
                if (curIndex >= arr.length){
                    break;
                }
            }

            for (int i = 0; i < arr.length; i++){
                arr[i] = tmp[i];
            }
        }
    }
}