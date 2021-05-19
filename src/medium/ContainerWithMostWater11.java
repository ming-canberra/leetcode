package medium;

import java.util.HashSet;

public class ContainerWithMostWater11 {
    public static void main(String[] args) {
        ContainerWithMostWater11 thisClass = new ContainerWithMostWater11();
    }

    public int maxArea(int[] height) {
        int lIndex = 0;
        int rIndex = height.length - 1;
        int result = 0;
        while (rIndex > lIndex){
            int curArea = (rIndex - lIndex) * Math.min(height[lIndex], height[rIndex]);

            result = Math.max(curArea, result);

            if (height[lIndex] < height[rIndex]){
                lIndex++;
            }
            else{
                rIndex--;
            }
        }
        return result;
    }
}