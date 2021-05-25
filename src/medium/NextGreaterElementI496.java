package medium;

import java.util.*;

public class NextGreaterElementI496 {
    public static void main(String[] args) {
        NextGreaterElementI496 thisClass = new NextGreaterElementI496();
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];

        HashMap<Integer, Integer> valueToIndex = new HashMap<>();

        for (int i = 0; i < nums1.length; i++){
            valueToIndex.put(nums1[i], i);
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = nums2.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && stack.peek() <= nums2[i]){
                stack.pop();
            }
            if (valueToIndex.containsKey(nums2[i])){
                int tmp = -1;
                if(!stack.isEmpty()){
                    tmp = stack.peek();
                }

                result[valueToIndex.get(nums2[i])] = tmp;
            }

            stack.push(nums2[i]);
        }

        return result;
    }
}