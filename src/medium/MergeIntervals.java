package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        MergeIntervals thisClass = new MergeIntervals();
        System.out.println (thisClass.merge(new int[][]{new int[]{8, 10}, new int[]{15, 18}}));
    }
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1){
            return intervals;
        }
        List<int[]> resultList = new ArrayList<int[]>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int curUpperLimit = intervals[0][1];
        int curLowerLimit = intervals[0][0];
        for (int i = 1; i < intervals.length; i++){
            if (intervals[i][0] > curUpperLimit){
                resultList.add(new int[]{curLowerLimit, curUpperLimit});
                curLowerLimit = intervals[i][0];
                curUpperLimit = intervals[i][1];
            }
            else{
                curUpperLimit = Math.max(curUpperLimit, intervals[i][1]);
            }
            if (i == intervals.length - 1){
                resultList.add(new int[]{curLowerLimit, curUpperLimit});
            }
        }
        int[][] result = new int[resultList.size()][2];
        for (int i = 0; i < resultList.size(); i++){
            result[i] = resultList.get(i);
        }
        return result;
    }
}