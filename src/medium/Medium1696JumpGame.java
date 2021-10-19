package medium;

import java.util.*;

public class Medium1696JumpGame {
    class Solution {
        public int maxResult(int[] nums, int k) {
            int len = nums.length;
            int[] dp = new int[len];
            dp[len - 1] = nums[len - 1];
            int maxIndex = len - 1;
            PriorityQueue<Integer> heap = new PriorityQueue<>((a, b)->dp[b] - dp[a]);//max heap
            for (int i = len - 2; i >= 0; i--){
                heap.add(i + 1);
                while(heap.peek() > i + k){
                    heap.poll();
                }
                dp[i] = nums[i] + dp[heap.peek()];
            }
            return dp[0];
        }
    }

    class Solution1 {
        public int maxResult(int[] nums, int k) {
            int len = nums.length;
            int[] dp = new int[len];
            dp[len - 1] = nums[len - 1];
            int maxIndex = len - 1;
            Deque<Integer> deque = new LinkedList<>();  // storing index
            deque.addLast(len - 1);

            for (int i = len - 2; i >= 0; i--){
                while( !deque.isEmpty() && dp[deque.peekFirst()] <= dp[i + 1]){
                    deque.pollFirst();
                }
                deque.addFirst(i + 1);

                if(deque.peekLast() > i + k){
                    deque.pollLast();
                }

                dp[i] = nums[i] + dp[deque.peekLast()];
            }
            return dp[0];
        }
    }
}