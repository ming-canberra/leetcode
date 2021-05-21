package easy;

import java.util.*;

public class PeakIndexInAMountainArray852 {
    public static void main(String[] args) {
        PeakIndexInAMountainArray852 thisClass = new PeakIndexInAMountainArray852();
    }
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        while (l + 1 < r){
            int m = l + (r - l) / 2;
            boolean mAscending = arr[m + 1] > arr[m] && arr[m] > arr[m - 1];
            if (mAscending){
                l = m + 1;
                continue;
            }
            boolean mDescending = arr[m + 1] < arr[m] && arr[m] < arr[m - 1];
            if (mDescending){
                r = m - 1;
                continue;
            }
            return m;
        }
        if (l == 0){
            return r;
        }
        if (r == arr.length - 1){
            return l;
        }
        if (arr[l - 1] < arr[l] && arr[l] > arr[l + 1]){
            return l;
        }
        else
        {
            return r;
        }
    }
}