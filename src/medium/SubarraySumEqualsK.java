package medium;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        SubarraySumEqualsK thisClass = new SubarraySumEqualsK();
        System.out.println (thisClass.subarraySum(new int[]{1,5,3,2,4}, 3));
    }
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();// stores counts of sums from 0 to leng-1
        int result = 0;
        int sum = nums[0];
        map.put(sum, 1);
        if (sum == k){
            result++;
        }
        for (int i = 1; i < nums.length; i++)
        {
            sum+=nums[i];
            if (sum == k) {
                result++;
            }
            result+=map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return result;
    }

    public int subarraySumBruteForce(int[] nums, int k) {
        int result = 0;
        for (int i = 0; i < nums.length; i++){
            int sum = 0;
            for (int j = i; j < nums.length; j++){
                sum+=nums[j];
                if (sum == k){
                    result++;
                }
            }
        }
        return result;
    }
}