package medium;

import java.util.*;

public class Medium1136ParallelCourses {
    class Solution {
        public int minimumSemesters(int n, int[][] relations) {
            int[] inDe = new int[n + 1];
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < relations.length; i++){
                inDe[relations[i][1]]++;
                List<Integer> newList = new ArrayList<>();
                List<Integer> tmpList = map.getOrDefault(relations[i][0], newList);
                tmpList.add(relations[i][1]);
                map.put(relations[i][0], tmpList);
            }
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i < n + 1; i++){
                if (inDe[i] == 0){
                    queue.add(i);
                }
            }
            int result = 0;
            int num = 0;
            while(!queue.isEmpty()){
                result++;
                int qSize = queue.size();
                for (int i = 0; i < qSize; i++){
                    int top = queue.poll();
                    num++;
                    if (map.containsKey(top)){
                        for (int j : map.get(top)){
                            inDe[j]--;
                            if (inDe[j] == 0){
                                queue.add(j);
                            }
                        }
                    }
                }
            }
            if (num == n){
                return result;
            }
            return -1;
        }
    }
}