package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum001 {
    public static void main(String[] args) {
        TwoSum001 thisClass = new TwoSum001();
        int[] result = thisClass.twoSum(null, 1);
        System.out.println(result);
    }

    public int[] twoSum(int[] nums, int target)
    {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

        for (int i = 0; i < nums.length; i++)
        {
            if (map.containsKey(nums[i]))
            {
                map.get(nums[i]).add(i);
            }
            else
            {
                List<Integer> indList = new ArrayList<Integer>();
                indList.add(i);
                map.put(nums[i], indList);
            }
        }

        for (int i = 0; i < nums.length; i++)
        {
            if (map.containsKey(target - nums[i]))
            {
                if (map.get(target - nums[i]).size() > 1)
                {
                    return new int[]{map.get(target - nums[i]).get(0), map.get(target - nums[i]).get(1)};
                }

                if (target - nums[i] != nums[i])
                {
                    return new int[]{i, map.get(target - nums[i]).get(0)};
                }
            }
        }


        return new int[]{0, 0};
    }

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> visited = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                if (visited.containsKey(target - nums[i])) {
                    return new int[]{i, visited.get(target - nums[i])};
                }
                else {
                    visited.put(nums[i], i);
                }
            }

            return new int[]{0, 1};
        }
    }
}