package easy;

public class ReplaceElementswithGreatestElementonRightSide1299 {
    class Solution {
        public int[] replaceElements(int[] arr) {
            int n = arr.length;
            int max = arr[n - 1];
            arr[n - 1] = -1;
            for (int i = n - 2; i >= 0; i--){
                int tmp = arr[i];
                arr[i] = max;
                max = Math.max(max, tmp);
            }
            return arr;
        }
    }
}