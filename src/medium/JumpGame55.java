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

    class SolutionNotOptimal {
        public boolean canJump(int[] nums) {
            int n = nums.length;
            int curI = 0;
            while(curI < n - 1){
                int max = curI;
                int nextI = curI;
                for (int i = curI + 1; i <= curI + nums[curI]; i++){
                    if (i >= n - 1){
                        return true;
                    }
                    if(i + nums[i] > max){
                        max = i + nums[i];
                        nextI = i;
                    }
                }
                if (max >= n - 1){
                    return true;
                }
                if (max == curI){
                    return false;
                }
                curI = nextI;

            }

            return true;

        }
    }
}