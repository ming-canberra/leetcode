package easy;

import java.util.HashSet;

public class DistributeCandies575 {
    public static void main(String[] args) {
        DistributeCandies575 thisClass = new DistributeCandies575();

        int nums[] = new int[4];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        nums[3] = 4;

        thisClass.distributeCandies(nums);
    }
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        HashSet<Integer> types = new HashSet<Integer>();

        for (int i =0; i< n;i++){
            types.add(candyType[i]);
            if (types.size() == n/2)
                break;
        }
        return  types.size();
    }

}