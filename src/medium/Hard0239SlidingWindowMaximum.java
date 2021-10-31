package medium;

import java.util.*;

public class Hard0239SlidingWindowMaximum {
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            Deque<Integer> deque = new ArrayDeque<>();
            int[] result = new int[nums.length - k + 1];
            int index = 0;
            for (int i = 0; i < nums.length; i++){
                if (!deque.isEmpty() && deque.peekFirst() <= i - k){
                    deque.pollFirst();
                }
                while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                    deque.pollLast();
                }
                deque.addLast(i);
                if (i >= k - 1){
                    result[index] = nums[deque.peekFirst()];
                    index++;
                }
            }
            return result;
        }
    }

    class Solution1 {
        public int[] maxSlidingWindow(int[] nums, int k) {
            List<Integer> result = new ArrayList<>();
            Deque<Integer> deque = new LinkedList<>();// index, in ascending order
            for (int i = 0; i < nums.length; i++){
                while(!deque.isEmpty() && nums[deque.peekFirst()] <= nums[i] ){
                    deque.pollFirst();
                }
                deque.addFirst(i);
                if (i - deque.peekLast() >= k ){
                    deque.pollLast();
                }
                if (i >= k - 1){
                    result.add(nums[deque.peekLast()]);
                }
            }
            int[] array = new int[result.size()];
            for (int i = 0; i < result.size(); i++){
                array[i] = result.get(i);
            }
            return array;
        }
    }
}