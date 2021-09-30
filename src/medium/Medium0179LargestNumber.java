package medium;

import java.util.*;

public class Medium0179LargestNumber {
    class Solution {
        public String largestNumber(int[] nums) {
            Integer[] integers = new Integer[nums.length];
            int index = 0;
            for (int i : nums){
                integers[index++] = i;
            }
            Arrays.sort(integers, new MyCom());
            StringBuilder sb = new StringBuilder();
            boolean leadingZero = true;
            for (int i = 0; i < integers.length; i++){
                if (integers[i] != 0){
                    leadingZero = false;
                }
                if (leadingZero){
                    continue;
                }
                else{
                    sb.append(integers[i].toString());
                }
            }
            if (sb.length() == 0){
                return "0";
            }
            return sb.toString();
        }
        class MyCom implements Comparator<Integer>{
            @Override
            public int compare(Integer a, Integer b){
                Long ab = Long.valueOf(a.toString() + b.toString());
                Long ba = Long.valueOf(b.toString() + a.toString());
                if (ab > ba){
                    return -1;
                }
                else if (ab < ba){
                    return 1;
                }
                return 0;
            }
        }
    }

    class Solution1 {
        public String largestNumber(int[] nums) {
            String[] strs = new String[nums.length];
            for (int i = 0; i < nums.length; i++){
                strs[i] = new Integer(nums[i]).toString();
            }
            Arrays.sort(strs, new MyCom());
            StringBuilder sb = new StringBuilder();
            for (int i = nums.length - 1; i >= 0; i--){
                if ( "0".equals(strs[i]) && "0".equals(sb.toString()) ){
                    continue;
                }
                sb.append(strs[i]);
            }
            return sb.toString();
        }
        class MyCom implements Comparator<String>{
            @Override
            public int compare(String a, String b){
                return (a + b).compareTo(b + a);
            }
        }
    }
}