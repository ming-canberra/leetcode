package medium;

import java.util.*;

public class Medium1817FindingtheUsersActiveMinutes {
    class Solution {
        public int[] findingUsersActiveMinutes(int[][] logs, int k) {
            Map<Integer, Set<Integer>> userToUAM = new HashMap<>();
            for (int[] pair : logs){
                int curMin = pair[1];
                int userid = pair[0];
                Set<Integer> cSet = userToUAM.getOrDefault(userid, new HashSet<>());
                cSet.add(curMin);
                userToUAM.put(userid, cSet);
            }
            int[] result = new int[k];
            for (int userid : userToUAM.keySet()){
                Set<Integer> cSet = userToUAM.get(userid);
                if (cSet.size() >= 1 && cSet.size() <= k){
                    result[cSet.size() - 1]++;
                }
            }
            return result;
        }
    }
}