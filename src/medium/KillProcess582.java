package medium;

import java.util.*;

public class KillProcess582 {
    class Solution {
        public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
            Map<Integer, List<Integer>> ppidToIndex = new HashMap<>();
            for (int i = 0; i < ppid.size(); i++){
                List<Integer> curList = ppidToIndex.getOrDefault(ppid.get(i), new ArrayList<Integer>());
                curList.add(i);
                ppidToIndex.put(ppid.get(i), curList);
            }
            List<Integer> result = new ArrayList<>();
            if (!ppidToIndex.containsKey(kill)){
                result.add(kill);
                return result;
            }
            else{
                Queue<Integer> q = new LinkedList<>();
                q.add(kill);
                while(!q.isEmpty()){
                    int size = q.size();
                    for (int i = 0; i < size; i++){
                        int curPpid = q.poll();
                        result.add(curPpid);
                        if (ppidToIndex.containsKey(curPpid)){
                            List<Integer> ppidIndexList = ppidToIndex.get(curPpid);
                            for (int index : ppidIndexList){
                                q.add(pid.get(index));
                            }
                        }
                    }
                }
            }
            return result;
        }
    }
}