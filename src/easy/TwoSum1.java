package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum1 {
    public static void main(String[] args) {
        TwoSum1 thisClass = new TwoSum1();
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
}