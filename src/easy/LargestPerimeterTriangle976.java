package easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LargestPerimeterTriangle976 {
    public static void main(String[] args) {
        LargestPerimeterTriangle976 thisClass = new LargestPerimeterTriangle976();
        int[][]input = new int[0][0];

        System.out.println(" " + thisClass.largestPerimeter(new int[]{2,5,3}));
    }
    public int largestPerimeter(int[] a) {
        Arrays.sort(a);
        for (int i = a.length - 1; i >=2; i--){
            int l = a[i];
            int m = a[i-1];
            int s = a[i-2];
            if (l < m+s){
                return l+m+s;
            }
        }
        return 0;
    }
}