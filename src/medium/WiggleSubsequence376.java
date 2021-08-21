package medium;

import java.util.Arrays;
//
public class WiggleSubsequence376 {
    public static void main(String[] args) {
        WiggleSubsequence376 thisClass = new WiggleSubsequence376();
        int res = thisClass.wiggleMaxLength(new int[]{1,7,4,9,2,5});
        System.out.println(res);
    }

    public int wiggleMaxLength(int[] nums)
    {
        if (nums.length == 1){
            return 1;
        }
        int up[] = new int[nums.length];
        int down[] = new int[nums.length];
        up[0] = 1;
        down[0] = 1;
        int toReturn = 0;
        for (int i = 1; i < nums.length; i++){
            int tempUp = 1;
            int tempDown = 1;
            for (int j = 0; j < i; j++)
            {
                if (nums[i] > nums[j]){
                    tempUp = Math.max(tempUp, down[j] + 1);
                }
                else if (nums[i] < nums[j]){
                    tempDown = Math.max(tempDown, up[j] + 1);
                }
            }
            up[i] = tempUp;
            down[i] = tempDown;
            toReturn = Math.max(toReturn, tempUp);
            toReturn = Math.max(toReturn, tempDown);
        }

        return toReturn;
    }

    class Solution {
        public int wiggleMaxLength(int[] nums) {
            int length = nums.length;
            int[] dpPos = new int[length];// last diff is pos, ending with ith element of nums;
            int[] dpNeg = new int[length];
            for (int i = 0; i < length; i++){
                int tmpNeg = 1;
                int tmpPos = 1;
                for (int j = 0; j < i; j++){
                    if (nums[i] > nums[j]){
                        tmpPos = Math.max(tmpPos, dpNeg[j] + 1);
                    }
                    if (nums[i] < nums[j]){
                        tmpNeg = Math.max(tmpNeg, dpPos[j] + 1);
                    }
                }
                dpPos[i] = tmpPos;
                dpNeg[i] = tmpNeg;
            }
            Arrays.sort(dpPos);
            Arrays.sort(dpNeg);
            return Math.max(dpPos[length - 1], dpNeg[length - 1]);
        }
    }
}