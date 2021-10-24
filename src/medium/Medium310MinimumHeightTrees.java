package medium;

import java.util.*;

public class Medium310MinimumHeightTrees {
    class Solution {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            if (n == 1){
                return Arrays.asList(new Integer[]{0});
            }
            if (n == 2){
                return Arrays.asList(new Integer[]{0, 1});
            }
            int[] deg = new int[n];
            int len = edges.length;
            Map<Integer, Set<Integer>> map = new HashMap();
            for (int i = 0; i < len; i++){
                deg[edges[i][0]]++;
                deg[edges[i][1]]++;
                map.putIfAbsent(edges[i][0], new HashSet<>());
                map.putIfAbsent(edges[i][1], new HashSet<>());
                map.get(edges[i][0]).add(edges[i][1]);
                map.get(edges[i][1]).add(edges[i][0]);
            }
            Set<Integer> result = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < n; i++){
                if (deg[i] == 1){
                    queue.add(i);
                }
                else{
                    result.add(i);
                }
            }
            while(result.size() != 1 && result.size() != 2){
                for (int i = queue.size(); i > 0; i--){
                    int top = queue.poll();
                    for (int deIndex : map.get(top)){
                        deg[deIndex]--;
                        if (deg[deIndex] == 1 && result.contains(deIndex)){
                            queue.add(deIndex);
                            result.remove(deIndex);
                        }
                    }
                }
            }
            return new ArrayList<>(result);
        }
    }

    class Solution1 {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            Set<Integer> resultSet = new HashSet<>();
            for (int i = 0; i < n; i++){
                resultSet.add(i);
            }
            int[] inDe = new int[n];
            Map<Integer, Set<Integer>> map = new HashMap<>();
            for (int i = 0; i < edges.length; i++){
                inDe[edges[i][0]]++;
                inDe[edges[i][1]]++;
                Set<Integer> set1 = map.getOrDefault(edges[i][0], new HashSet<>());
                set1.add(edges[i][1]);
                map.put(edges[i][0], set1);

                Set<Integer> set2 = map.getOrDefault(edges[i][1], new HashSet<>());
                set2.add(edges[i][0]);
                map.put(edges[i][1], set2);
            }
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < n; i++){
                if (inDe[i] == 1){
                    q.add(i);
                }
            }
            while(resultSet.size() > 2){
                for (int size = q.size(); size > 0; size--){
                    int top = q.poll();
                    resultSet.remove(top);
                    for (int i : map.get(top)){
                        inDe[i]--;
                        if (inDe[i] == 1){
                            q.add(i);
                        }
                        map.get(i).remove(top);
                    }
                }
            }
            return new ArrayList<>(resultSet);
        }
    }
    class Solution2 {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            List<Set<Integer>> vertices = new ArrayList<>();
            Set<Integer> result = new HashSet<>();
            for (int i = 0; i < n; i++){
                vertices.add(new HashSet<>());
                result.add(i);
            }
            int[] inDe = new int[n];
            for (int i = 0; i < edges.length; i++){
                inDe[edges[i][0]]++;
                inDe[edges[i][1]]++;
                vertices.get(edges[i][0]).add(edges[i][1]);
                vertices.get(edges[i][1]).add(edges[i][0]);
            }
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < n; i++){
                if (inDe[i] == 1){
                    q.add(i);
                }
            }
            while(result.size() > 2){
                for (int size = q.size(); size > 0; size--){
                    int top = q.poll();
                    result.remove(top);
                    for (int i : vertices.get(top)){
                        vertices.get(i).remove(top);
                        inDe[i]--;
                        if (inDe[i] == 1){
                            q.add(i);
                        }
                    }
                }
            }
            return new ArrayList<>(result);
        }
    }
    class Solution3 {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            Set<Integer> resultSet = new HashSet<>();
            List<Set<Integer>> vertexList = new ArrayList<>();
            for (int i = 0; i < n; i++){
                resultSet.add(i);
                vertexList.add(new HashSet<>());
            }
            if (resultSet.size() < 3){
                return new ArrayList<>(resultSet);
            }
            for (int[] edge : edges){
                vertexList.get(edge[0]).add(edge[1]);
                vertexList.get(edge[1]).add(edge[0]);
            }
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < n; i++){
                Set<Integer> set = vertexList.get(i);
                if (set.size() == 1){
                    queue.add(i);
                    resultSet.remove(i);
                }
            }
            while(resultSet.size() > 2){
                for (int size = queue.size(); size > 0; size--){
                    int top = queue.poll();
                    Set<Integer> singleValueSet = vertexList.get(top);
                    int secondV = (new ArrayList<>(singleValueSet)).get(0);
                    vertexList.get(secondV).remove(top);
                    if (vertexList.get(secondV).size() == 1){
                        queue.add(secondV);
                        resultSet.remove(secondV);
                    }
                }
            }
            return new ArrayList<>(resultSet);
        }
    }
}