package medium;

public class RangeAddition370 {
    class Solution {
        public int[] getModifiedArray(int length, int[][] updates) {
            int[] arr = new int[length];
            for (int i = 0; i < updates.length; i++){
                int start = updates[i][0];
                int end = updates[i][1];
                int inc = updates[i][2];
                arr[start] += inc;
                if (end + 1 < arr.length){
                    arr[end + 1] -= inc;
                }
            }
            for (int i = 1; i < arr.length; i++){
                arr[i] = arr[i - 1] + arr[i];
            }
            return arr;
        }
    }
}