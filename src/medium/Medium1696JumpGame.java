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
}