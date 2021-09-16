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

    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            HashMap<Integer, List<int[]>> prereqToAffected = new HashMap<Integer, List<int[]>>();
            HashMap<Integer, Integer> courseToPrereqCount = new HashMap<Integer, Integer>();
            for (int i = 0; i < prerequisites.length; i++){
                int[] cur = prerequisites[i];

                int count = courseToPrereqCount.getOrDefault(cur[0], 0) + 1;
                courseToPrereqCount.put(cur[0], count);

                List<int[]> affected = prereqToAffected.getOrDefault(cur[1], new ArrayList<int[]>());
                affected.add(cur);

                prereqToAffected.put(cur[1], affected);
            }
            Queue<Integer> q = new LinkedList<>();

            for (int i = 0; i < numCourses; i++){
                if (!courseToPrereqCount.containsKey(i)){
                    q.add(i);
                }
            }
            List<Integer> result = new ArrayList<>();
            while(!q.isEmpty()){
                int top = q.poll();
                result.add(top);
                if (prereqToAffected.containsKey(top)){
                    List<int[]> affected = prereqToAffected.get(top);
                    for (int[] pre : affected){
                        int count = courseToPrereqCount.get(pre[0]);
                        count--;
                        courseToPrereqCount.put(pre[0], count);
                        if (count == 0){
                            q.add(pre[0]);
                        }
                    }
                }
            }

            int[] toReturn = new int[numCourses];
            if (result.size() == numCourses){
                for (int i = 0; i < result.size(); i++){
                    toReturn[i] = result.get(i);
                }
                return toReturn;
            }
            else{
                return new int[0];
            }
        }
    }
    class Solution1 {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            int[] inDe = new int[numCourses];
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < prerequisites.length; i++){
                inDe[prerequisites[i][0]]++;
                List<Integer> newList = new ArrayList<>();
                List<Integer> tmpList = map.getOrDefault(prerequisites[i][1], newList);
                tmpList.add(prerequisites[i][0]);
                map.put(prerequisites[i][1], tmpList);
            }
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < inDe.length; i++){
                if (inDe[i] == 0){
                    queue.add(i);
                }
            }
            int index = 0;
            int[] result = new int[numCourses];
            while(!queue.isEmpty()){
                int top = queue.poll();
                result[index++] = top;
                if (map.containsKey(top)){
                    for (int i : map.get(top)){
                        inDe[i]--;
                        if (inDe[i] == 0){
                            queue.add(i);
                        }
                    }
                }
            }
            if (index == numCourses){
                return result;
            }
            return new int[0];
        }
    }
}