package medium;

import java.util.*;

public class LongestTurbulentSubarray978 {
    class Solution {
        public int maxTurbulenceSize(int[] arr) {
            int result = 1;
            int left = 0;
            int lastTurb = 0;// -1 means arr[i - 1] < arr[i]   1 means arr[i - 1] > arr[i]
            for (int right = 1; right < arr.length; right++){
                int compare = Integer.compare(arr[right - 1], arr[right]);
                if (compare == 0){
                    left = right;
                    lastTurb = 0;
                }
                else if (compare == lastTurb){
                    left = right - 1;
                }
                else{
                    result = Math.max(result, right - left + 1);
                    lastTurb = compare;
                }
            }
            return result;
        }
    }
}