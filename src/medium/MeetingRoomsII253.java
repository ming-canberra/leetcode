package medium;

import java.util.*;

public class MeetingRoomsII253 {
    public static void main(String[] args) {
        MeetingRoomsII253 thisClass = new MeetingRoomsII253();
        int res = thisClass.minMeetingRooms(new int[][]{new int[]{1,2}});
        System.out.println(res);
    }

    public int minMeetingRoomsHeap(int[][] intervals){
        Arrays.sort(intervals, (a, b)-> a[1] - b[1]);
        // this stores the conferences in session, order by ending time, the earliest is the head
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(new MyCom());
        heap.add(intervals[0]);
        int result = 1;
        for (int i = 1; i < intervals.length; i++)
        {
            int[] top = heap.peek();
            if (intervals[i][0] < top[1]){
                result++;
            }
            else{
                heap.poll();
            }
            heap.add(intervals[i]);
        }
        return result;
    }

    private class MyCom implements Comparator<int[]>
    {
        @Override
        public int compare(int[] a, int[] b) {
            return Integer.compare(a[1], b[1]);
        }
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