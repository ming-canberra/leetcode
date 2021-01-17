package easy;

import java.util.HashSet;

public class SetMismatch645 {
    public static void main(String[] args) {
        SetMismatch645 thisClass = new SetMismatch645();
        System.out.println(thisClass.findErrorNums(new int[]{1,12,-5,-6,50,3}));
    }

    public int[] findErrorNums(int[] nums) {
        int sumInTheory = (nums.length + 1 ) * nums.length /2;
        int[] toReturn = new int[2];
        int sumInReal = 0;
        HashSet<Integer> container = new HashSet<Integer>();
        for (int i = 0; i< nums.length;i++){
            if (container.contains(nums[i])){
                toReturn[0]= nums[i];
            }
            else{
                container.add(nums[i]);
                sumInReal += nums[i];
            }
        }
        toReturn[1] = sumInTheory - sumInReal;
        return toReturn;
    }
}