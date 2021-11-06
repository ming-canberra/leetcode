package medium;

import java.util.*;

public class Medium0841KeysandRooms {
    class Solution {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            int n = rooms.size();
            Set<Integer> unlockedRooms = new HashSet<>();
            unlockedRooms.add(0);
            Queue<Integer> keyQueue = new LinkedList<>();
            keyQueue.addAll(rooms.get(0));
            while(!keyQueue.isEmpty()){
                int topKey = keyQueue.poll();
                if (!unlockedRooms.contains(topKey)){
                    keyQueue.addAll(rooms.get(topKey));
                    unlockedRooms.add(topKey);
                }
                if (unlockedRooms.size() == n){
                    return true;
                }
            }
            return unlockedRooms.size() == n;
        }
    }
}