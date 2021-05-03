package medium;

import java.util.*;

public class CourseScheduleII210 {
    private Object HashSet;

    public static void main(String[] args) {
        CourseScheduleII210 thisClass = new CourseScheduleII210();
        System.out.println (thisClass.findOrder(1, null));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        int rIndex = 0;

        int[] inDegree = new int[numCourses];// for i, the number of prerequisites to take before doing course i

        // a helper to quickly work out given a course i, what course(s) has i as prerequisite.
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

        for (int i = 0; i < prerequisites.length; i++){
            int pre = prerequisites[i][1];
            int con = prerequisites[i][0];
            inDegree[con]++;
            List<Integer> intList = map.getOrDefault(pre, new ArrayList<Integer>());
            intList.add(con);
            map.put(pre, intList);
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++){
            if (inDegree[i] == 0){
                q.add(i);
            }
        }
        while (!q.isEmpty()){
            int node = q.poll();
            result[rIndex++] = node;
            if (map.get(node) != null){
                for (int tmpInt : map.get(node)){
                    inDegree[tmpInt]--;
                    if (inDegree[tmpInt] == 0){
                        q.add(tmpInt);
                    }
                }
            }
        }

        if (rIndex == numCourses){
            return result;
        }
        else{
            return new int[0];
        }
    }
}