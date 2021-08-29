package medium;

import java.util.HashMap;
import java.util.Map;

public class CarPooling1094 {
    class Solution {
        public boolean carPooling(int[][] trips, int capacity) {
            int[] stops = new int[1001];
            for (int i = 0; i < trips.length; i++){
                int num = trips[i][0];
                int fromIndex = trips[i][1];
                int toIndex = trips[i][2];
                stops[fromIndex] += num;
                stops[toIndex] -= num;
            }
            int sum = 0;
            for (int i = 0; i < stops.length; i++){
                sum += stops[i];
                if (sum > capacity){
                    return false;
                }
            }
            return true;
        }
    }
}