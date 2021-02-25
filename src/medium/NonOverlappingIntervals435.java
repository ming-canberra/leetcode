package medium;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals435 {
    public static void main(String[] args) {
        NonOverlappingIntervals435 thisClass = new NonOverlappingIntervals435();
        int ans = thisClass.eraseOverlapIntervals(new int[][]{
                new int[]{1,100},
                new int[]{11,22},
                new int[]{1,11},
                new int[]{2,12}});

        System.out.println(ans);
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals, new MyComparator());
        int currentBoundary = intervals[0][1];
        int counter = 1;
        for (int i = 1; i < intervals.length; i++){
            if (intervals[i][1] > currentBoundary && currentBoundary<=intervals[i][0]){
                counter++;
                currentBoundary = intervals[i][1];
            }
        }
        return intervals.length - counter;
    }

    private class MyComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] emp1, int[] emp2) {
            return emp1[1] - emp2[1];
        }
    }
}