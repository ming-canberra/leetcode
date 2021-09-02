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

    class Solution1 {
        public int maxTurbulenceSize(int[] arr) {
            int len = arr.length;
            int result = 1;
            int status = 0;// 1 ascending, -1 descending, 0 flat
            int curResult = 1;
            for (int i = 1; i < len; i++){
                if (arr[i - 1] < arr[i]){  //when ascending
                    if (status > 0){
                        curResult = 2;
                    }
                    else if (status < 0){
                        curResult++;
                    }
                    else{
                        curResult = 2;
                    }
                    status = 1;
                }
                else if (arr[i - 1] > arr[i]){ // when descending
                    if (status < 0){
                        curResult = 2;
                    }
                    else if (status > 0){
                        curResult++;
                    }
                    else{
                        curResult = 2;
                    }
                    status = -1;
                }
                else{   //going flat
                    curResult = 1;
                    status = 0;
                }
                result = Math.max(result, curResult);
            }
            return result;
        }
    }
}