package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CourseScheduleII210 {
    private Object HashSet;

    public static void main(String[] args) {
        CourseScheduleII210 thisClass = new CourseScheduleII210();
        System.out.println (thisClass.findOrder(1, null));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Arrays.sort(prerequisites, (a,b)->a[0] - b[0]);

        Set<Integer> result = new HashSet<Integer>();
        int pIndex = 0;
        for (int i = 0; i < numCourses; i++){

        }


        return null;
    }
}