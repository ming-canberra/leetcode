package medium;

public class JumpGame55 {
    class Solution {
        public boolean canJump(int[] nums) {
            int n = nums.length;
            int max = 0;
            if (n == 1){
                return true;
            }
            for (int i = 0; i < n - 1; i++){
                if (nums[i] != 0 ){
                    int curMax = i + nums[i];
                    if (curMax > max){
                        max = curMax;
                        if (max >= n - 1){
                            return true;
                        }
                    }
                }
                else{
                    if (max <= i){
                        return false;
                    }
                }
            }
            return false;
        }
    }
}