package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Medium0731MyCalendarII {
    public static void main(String[] args) {
        Medium0731MyCalendarII thisClass = new Medium0731MyCalendarII();
    }

    class MyCalendarTwo {
        List<int[]> singleList = new ArrayList<>();
        List<int[]> doubleList = new ArrayList<>();
        public MyCalendarTwo() {

        }
        public boolean book(int start, int end) {
            int[] curBooking = new int[]{start, end};
            if (overlap(doubleList, curBooking)){
                return false;
            }

            for (int[] existing : singleList){
                int maxStart = Math.max(existing[0], curBooking[0]);
                int minEnd = Math.min(existing[1], curBooking[1]);
                if (maxStart < minEnd){
                    doubleList.add(new int[]{maxStart, minEnd});
                }
            }

            singleList.add(curBooking);

            return true;
        }
        private boolean overlap(List<int[]> list, int[] booking){
            for (int[] existing : list){
                int maxStart = Math.max(existing[0], booking[0]);
                int minEnd = Math.min(existing[1], booking[1]);
                if (maxStart < minEnd){
                    return true;
                }
            }
            return false;
        }
    }
}