package medium;

public class ArithmeticSlices413 {
    public static void main(String[] args) {
        ArithmeticSlices413 thisClass = new ArithmeticSlices413();

        int res = thisClass.numberOfArithmeticSlices(new int[]{1,2,3,4});
        System.out.println(res);
    }
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3){
            return 0;
        }
        else{
            int[] diffs = new int[nums.length -1];
            for (int i = 0; i< diffs.length;i++){
                diffs[i] =nums[i+1] - nums[i];
            }
            int[] diffsOfDiffes = new int[nums.length -2];
            for (int i = 0; i < diffsOfDiffes.length;i++){
                diffsOfDiffes[i] = diffs[i+1] - diffs[i];
            }
            int i = -1;
            int toReturn = 0;
            while ( i < diffsOfDiffes.length){
                i++;
                int tempCounter = 0;
                if (i < diffsOfDiffes.length && diffsOfDiffes[i] == 0) {
                    while (i < diffsOfDiffes.length && diffsOfDiffes[i] == 0) {
                        tempCounter++;
                        i++;
                    }
                    toReturn+=(tempCounter + 1)* tempCounter/2;
                }
            }
            return toReturn;
        }
    }

    class Solution {
        public int numberOfArithmeticSlices(int[] nums) {
            if (nums.length < 3){
                return 0;
            }
            int result = 0;
            int preCount = 0;
            int preDiff = nums[1] - nums[0];
            for (int i = 2; i < nums.length; i++){
                int diff = nums[i] - nums[i - 1];
                if (diff == preDiff){
                    preCount++;
                }
                else{
                    preDiff = diff;
                    preCount = 0;
                }
                result += preCount;
            }
            return result;
        }
    }
}