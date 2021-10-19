package medium;

import java.util.*;

public class Medium1871JumpGameVII {
    class Solution {
        public boolean canReach(String s, int minJump, int maxJump) {
            int len = s.length();
            boolean[] dp = new boolean[len];
            if (s.charAt(len - 1) == '1'){
                return false;
            }
            dp[len - 1] = true;
            Deque<Integer> deque = new LinkedList<>();
            for (int i = len - 1 - minJump; i >= 0; i--){
                if (dp[i + minJump]){
                    deque.addFirst(i + minJump);
                }
                if (!deque.isEmpty()){
                    if (deque.peekLast() > i + maxJump){
                        deque.pollLast();
                    }
                }
                if (s.charAt(i) == '0' && !deque.isEmpty()){
                    dp[i] = true;
                }
            }
            return dp[0];
        }
    }
}