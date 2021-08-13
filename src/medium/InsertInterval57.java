package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval57 {
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<int[]> list = new ArrayList<>();
            if (intervals.length == 0){
                list.add(newInterval);
            }
            else{
                if (intervals[0][0] > newInterval[1]){
                    list.add(newInterval);
                }
                for (int i = 0; i < intervals.length; i++){
                    if (intervals[i][0] > newInterval[1]){
                        list.add(intervals[i]);
                    }
                    else if (intervals[i][1] < newInterval[0]){
                        list.add(intervals[i]);
                        if (i + 1 < intervals.length && intervals[i + 1][0] > newInterval[1]){
                            list.add(newInterval);
                        }
                    }
                    else{
                        int low = Math.min(intervals[i][0], newInterval[0]);
                        int high = Math.max(intervals[i][1], newInterval[1]);
                        while(i + 1 < intervals.length && intervals[i + 1][0] <= high){
                            i++;
                            high = Math.max(intervals[i][1], high);
                        }
                        list.add(new int[]{low, high});
                    }
                }
                if (list.get(list.size() - 1)[1] < newInterval[0]){
                    list.add(newInterval);
                }
            }
            int[][] result = new int[list.size()][2];
            for (int i = 0; i < list.size(); i++){
                result[i] = list.get(i);
            }
            return result;
        }
    }
}