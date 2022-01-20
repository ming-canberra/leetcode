package medium;

import java.util.*;

public class Medium0729MyCalendarI {
    class MyCalendar {
        List<int[]> list = new ArrayList<>();
        public MyCalendar() {
        }
        public boolean book(int start, int end) {
            if (list.isEmpty()){
                list.add(new int[]{start, end});
                return true;
            }
            else{
                int left = -1;
                int right = list.size();
                // find the index where equals to start, or biggest element less than start
                while(left + 1 < right){
                    int m = (left + right) / 2;
                    if (list.get(m)[0] == start){
                        return false;
                    }
                    else if (list.get(m)[0] < start){
                        left = m;
                    }
                    else{
                        right = m;
                    }
                }
                // all elements are greater than start, check if this can be at 0th
                if (left == -1){
                    if (list.get(0)[0] >= end ){
                        list.add(0, new int[]{start, end});
                        return true;
                    }
                    else{
                        return false;
                    }
                }
                else{
                    // check if this can sit at left + 1 idx
                    if (left + 1 == list.size()){
                        //check left element only
                        if (list.get(left)[1] <= start ){
                            list.add(left + 1, new int[]{start, end});
                            return true;
                        }
                        else{
                            return false;
                        }
                    }
                    else{
                        // check both left element and left + 1 element
                        if (list.get(left)[1] <= start && end <= list.get(left + 1)[0] ){
                            list.add(left + 1, new int[]{start, end});
                            return true;
                        }
                        else{
                            return false;
                        }
                    }
                }
            }
        }
    }

    class MyCalendar1 {
        List<int[]> eventsList = new ArrayList<>();
        public MyCalendar1() {
        }
        public boolean book(int start, int end) {
            for (int[] evt : eventsList){
                int maxOfMins = Math.max(start, evt[0]);
                int minOfMaxs = Math.min(end, evt[1]);
                // overlapped
                if (maxOfMins < minOfMaxs){
                    return false;
                }
            }
            eventsList.add(new int[]{start, end});
            return true;
        }
    }
}