package medium;

import java.util.Arrays;

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
}