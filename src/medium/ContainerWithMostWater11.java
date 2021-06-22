package medium;

import java.util.*;

public class ContainerWithMostWater11 {
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

    class Solution {
        public int maxArea(int[] height) {
            int result = 0;
            int n = height.length;
            int l = 0;
            int r = n - 1;
            while (l < r){
                int area = (r - l) * Math.min(height[l], height[r]);
                result = Math.max(result, area);
                if (height[l] < height[r]){
                    int ori = height[l];
                    while (l < r && height[l] <= ori){
                        l++;
                    }
                }
                else{
                    int ori = height[r];
                    while (l < r && height[r] <= ori ){
                        r--;
                    }
                }
            }
            return result;
        }
    }
}