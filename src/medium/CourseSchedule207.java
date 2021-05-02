package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule207 {
    public static void main(String[] args) {
        CourseSchedule207 thisClass = new CourseSchedule207();

    }
    Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

    private void initMap(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < prerequisites.length; i++){
            if (map.containsKey(prerequisites[i][0]))
            {
                map.get(prerequisites[i][0]).add(prerequisites[i][1]);
            }
            else
            {
                List<Integer> list = new ArrayList<Integer>();
                list.add(prerequisites[i][1]);
                map.put(prerequisites[i][0], list);
            }
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        initMap(numCourses, prerequisites);
        boolean[] visited = new boolean[numCourses];
        boolean[] checked = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++){
            if (isCycleFound(i, visited, checked)){
                return false;
            }
        }
        return true;
    }

    private boolean isCycleFound(int node, boolean[] visited, boolean[] checked){
        if (checked[node]){
            return false;
        }
        if (!map.containsKey(node)){
            checked[node] = true;
            return false;
        }
        if (visited[node]){
            return true;
        }
        visited[node] = true;
        for (Integer child : map.get(node)){
            if (isCycleFound(child, visited, checked))
            {
                return true;
            }
        }
        visited[node] = false;
        checked[node] = true;
        return false;
    }
}