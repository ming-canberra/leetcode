package medium;

import java.util.*;

public class Medium0398RandomPickIndex {
    class Solution {

        Map<Integer, List<Integer>> map = new HashMap<>();

        public Solution(int[] nums) {
            for (int i = 0; i < nums.length; i++){
                List<Integer> idxList = map.getOrDefault(nums[i], new ArrayList<>());
                idxList.add(i);
                map.put(nums[i], idxList);
            }
        }

        public int pick(int target) {
            List<Integer> idxList = map.get(target);
            if (idxList.size() == 1){
                return idxList.get(0);
            }

            Random random = new Random();
            return idxList.get(random.nextInt(idxList.size()) );
        }
    }
}