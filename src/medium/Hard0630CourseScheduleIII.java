package medium;

import java.util.*;

public class Hard0630CourseScheduleIII {
    class Solution {
        public int scheduleCourse(int[][] courses) {
            Arrays.sort(courses, (a, b)-> a[1] - b[1] );
            PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a, b)->courses[b][0] - courses[a][0]);
            int endingDay = 0;
            for (int i = 0; i < courses.length; i++){
                if (endingDay + courses[i][0] <= courses[i][1]){
                    endingDay += courses[i][0];
                    heap.add(i);
                }
                else{
                    if (!heap.isEmpty()){
                        int topIndex = heap.peek();
                        if (courses[topIndex][0] >= courses[i][0]){
                            heap.poll();
                            heap.add(i);
                            endingDay = endingDay - courses[topIndex][0] + courses[i][0];
                        }
                    }
                }
            }
            return heap.size();
        }
    }

    class Solution1 {
        public int scheduleCourse(int[][] courses) {
            // 0th duration, 1th last day
            Arrays.sort(courses, (a, b)-> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1] );
            int sumDays = 0;
            PriorityQueue<Integer> heap = new PriorityQueue<Integer>(  (a, b) -> b - a );// max heap
            for (int i = 0; i < courses.length; i++){
                int[] course = courses[i];
                if (sumDays + course[0] <= course[1]){
                    heap.add(course[0]);
                    sumDays += course[0];
                }
                // can not add current course directly
                else{
                    if (!heap.isEmpty()){
                        if (course[0] < heap.peek()){
                            int prevMax = heap.poll();
                            heap.add(course[0]);
                            sumDays = sumDays - prevMax + course[0];
                        }
                    }
                }
            }
            return heap.size();
        }
    }
}