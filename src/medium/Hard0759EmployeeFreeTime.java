package medium;

import java.util.*;

public class Hard0759EmployeeFreeTime {
    class Interval {
        public int start;
        public int end;

        public Interval() {}

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    };


    class Solution {
        public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
            PriorityQueue<Interval> heap = new PriorityQueue<>( (a, b) -> a.start - b.start  );
            for (List<Interval> list : schedule){
                for (Interval intel : list){
                    heap.add(intel);
                }
            }
            List<Interval> result = new ArrayList<>();
            int timeBusy = heap.peek().start;
            while(!heap.isEmpty()){
                Interval top = heap.poll();
                if (timeBusy >= top.start){
                    timeBusy = Math.max(timeBusy, top.end);
                }
                else{
                    result.add(new Interval(timeBusy, top.start));
                    timeBusy = top.end;
                }
            }
            return result;
        }
    }
}