package medium;

import java.util.*;

public class LeastNumberOfUniqueIntegersAfterKRemovals1481 {
    /**
     * N + M*LogM
     * */
    class Solution {
        public int findLeastNumOfUniqueInts(int[] arr, int k) {
            Map<Integer, Integer> intFrq = new HashMap<>();
            for (int i : arr){
                intFrq.put(i, intFrq.getOrDefault(i, 0) + 1);
            }
            List<Integer> list = new ArrayList<>();
            list.addAll(intFrq.values());
            Collections.sort(list);
            int result = list.size();
            for (int i = 0; i < list.size(); i++){
                int curVal = list.get(i);
                if (k >= curVal){
                    k -= curVal;
                    result--;
                    if (k == 0){
                        break;
                    }
                }
                else{
                    k = 0;
                    break;
                }
            }
            return result;
        }
    }
}