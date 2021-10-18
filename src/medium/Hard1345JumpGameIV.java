package medium;

import java.util.*;

public class Hard1345JumpGameIV {
    class Solution {
        public int minJumps(int[] arr) {
            int len = arr.length;
            boolean[] visited = new boolean[len];
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < len; i++){
                List<Integer> indexList = map.getOrDefault(arr[i], new ArrayList<>());
                indexList.add(i);
                map.put(arr[i], indexList);
            }
            int steps = 0;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(0);
            while(!queue.isEmpty()){
                for (int size = queue.size();size > 0; size--){
                    int top = queue.poll();

                    if (top < 0 || top >= len){
                        continue;
                    }
                    if (top == len - 1){
                        return steps;
                    }

                    if (visited[top]){
                        continue;
                    }
                    visited[top] = true;
                    queue.add(top + 1);
                    queue.add(top - 1);

                    if (map.containsKey(arr[top])){
                        List<Integer> indexList = map.get(arr[top]);
                        for (int listItem : indexList){
                            if (listItem != top){
                                queue.add(listItem);
                            }
                        }
                        map.remove(arr[top]);
                    }
                }
                steps++;
            }
            return len - 1;
        }
    }
}