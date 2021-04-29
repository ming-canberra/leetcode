package easy;

import java.util.Arrays;
import java.util.Stack;

public class MaximumUnitsOnATruck {
    public static void main(String[] args) {
        MaximumUnitsOnATruck thisClass = new MaximumUnitsOnATruck();
        System.out.println(thisClass.maximumUnits(null, 3));
    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int volumeLeft = truckSize;
        int result = 0;
        for (int i = 0; i < boxTypes.length; i++){
            if ( volumeLeft >= boxTypes[i][0] ){
                volumeLeft = volumeLeft - boxTypes[i][0];
                result = result + (boxTypes[i][0] * boxTypes[i][1]);
            }
            else{
                result = result + (volumeLeft * boxTypes[i][1]);
                break;
            }
        }
        return result;
    }
}