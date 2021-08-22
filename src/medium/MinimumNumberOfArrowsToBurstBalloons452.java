package medium;

import java.util.*;

public class MinimumNumberOfArrowsToBurstBalloons452 {
    class Solution {
        public int findMinArrowShots(int[][] points) {
            Arrays.sort(points, (a, b)-> Integer.compare(a[1], b[1]));
            int count = 1;
            int arrowPos = points[0][1];
            for (int i = 1; i < points.length; i++){
                while(i < points.length && points[i][0] <= arrowPos){
                    i++;
                }
                if(i >= points.length){
                    break;
                }
                count++;
                arrowPos = points[i][1];
            }
            return count;
        }
    }

}