package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeetingRoomsII253 {
    public static void main(String[] args) {
        MeetingRoomsII253 thisClass = new MeetingRoomsII253();
        int res = thisClass.minMeetingRooms(new int[][]{new int[]{1,2}});
        System.out.println(res);
    }
    public int minMeetingRooms(int[][] intervals) {
        // sort by end time
        Arrays.sort(intervals, (a, b)->Integer.compare(a[1], b[1]));

        List<Integer> list = new ArrayList<Integer>();

        //add first meeting end time
        list.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++)
        {
            // if start time < list.get(0); add end time of i to the list
            // else delete the first element, add current end time to the end

            if (intervals[i][0] < list.get(0)){
                list.add(intervals[i][1]);
            }
            else{
                // remove the one from the end
                for (int j = list.size() - 1; j >=0; j--){
                    if (list.get(j) <= intervals[i][0]){
                        list.remove(j);
                        break;
                    }
                }

                list.add(intervals[i][1]);
            }
        }

        return list.size();
    }
}