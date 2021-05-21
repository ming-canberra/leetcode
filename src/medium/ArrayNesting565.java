package medium;

import java.util.*;

public class ArrayNesting565 {
    public static void main(String[] args) {
        ArrayNesting565 thisClass = new ArrayNesting565();

        int res = thisClass.arrayNesting(new int[]{5,4,0,3,1,6,2});
        System.out.println(res);
    }
    public int arrayNesting(int[] nums) {
        int toReturn = 0;
        HashSet<Integer> iterationSet = new HashSet<Integer>();
        HashSet<Integer> currentSet = new HashSet<Integer>();
        for (int i = 0; i < nums.length;i++){
            if (toReturn >= nums.length -i){
                break;
            }
            if (!iterationSet.contains(i)){
                iterationSet.add(i);

                if (currentSet.isEmpty()){
                    int temp = nums[i];
                    while (!currentSet.contains(temp)){
                        currentSet.add(temp);
                        iterationSet.add(temp);
                        temp = nums[temp];
                    }
                    toReturn = Math.max(toReturn, currentSet.size());
                    currentSet.clear();
                }
            }
        }

        return toReturn;
    }
}