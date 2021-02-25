package easy;

import medium.NonOverlappingIntervals435;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloons452 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        MinimumNumberOfArrowsToBurstBalloons452 thisClass = new MinimumNumberOfArrowsToBurstBalloons452();
        System.out.println(thisClass.findMinArrowShots(new int[][]{new int[]{-2147483646,-2147483645}, new int[]{2147483646,2147483647} }));

    }
    public int findMinArrowShots(int[][] points) {
        return 1111;
    }

    private class MyComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] emp1, int[] emp2) {
            if (emp1[1] > emp2[1])
            return 1;
            else if ((emp1[1] ==emp2[1])){
                return 0;
            }
            else
            return -1;
        }
    }

}