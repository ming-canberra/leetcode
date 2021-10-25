package medium;

import java.util.*;

public class LengthofLongestFibonacciSubsequence873 {
    class Solution {
        public int lenLongestFibSubseq(int[] arr) {
            Set<Integer> set = new HashSet<>();
            for (int i : arr){
                set.add(i);
            }
            int max = 2;
            int n = arr.length;
            for (int i = 0; i < n - 2; i++){
                for (int j = i + 1; j < n - 1; j++){
                    int xI = arr[i];
                    int xI1 = arr[j];
                    int curMax = 2;
                    while(set.contains(xI + xI1)){
                        curMax++;
                        int tmp = xI + xI1;
                        xI = xI1;
                        xI1 = tmp;
                    }
                    max = Math.max(max, curMax);
                }
            }
            return max == 2 ? 0 : max;
        }
    }

    class Solution1 {
        public int lenLongestFibSubseq(int[] arr) {
            int len = arr.length;
            int[][]dp = new int[len][len];
            for (int i = 0; i < len; i++){
                for (int j = 0; j < len; j++){
                    dp[i][j] = 2;
                }
            }
            int result = 2;
            for (int i = 2; i < len; i++){
                int left = 0;
                int right = i - 1;
                while(left < right){
                    if (arr[left] + arr[right] == arr[i]){
                        dp[right][i] = dp[left][right] + 1;
                        result = Math.max(result, dp[right][i]);
                        left++;
                        right--;
                    }
                    else if (arr[left] + arr[right] < arr[i]){
                        left++;
                    }
                    else{
                        right--;
                    }
                }
            }
            return result == 2 ? 0 : result;
        }
    }

    class Solution2 {
        public int lenLongestFibSubseq(int[] arr) {
            Map<Integer, Integer> map = new HashMap<>();
            int len = arr.length;
            int[][] dp = new int[len][len];
            int result = 2;
            for (int i = 0; i < len; i++){
                for (int j = 0; j < len; j++){
                    dp[i][j] = 2;
                }
            }
            for (int i = 1; i < len - 1; i++){
                map.put(arr[i - 1], i - 1);
                for (int j = i + 1; j < len; j++){
                    int firstValue = arr[j] - arr[i];
                    if (map.containsKey(firstValue)){
                        dp[i][j] = dp[map.get(firstValue)][i] + 1;
                        result = Math.max(result, dp[i][j]);
                    }
                }
            }
            return result == 2 ? 0 : result;
        }
    }

    class Solution3 {
        public int lenLongestFibSubseq(int[] arr) {
            List<Map<Integer, Integer>> dpList = new ArrayList<>();  // index to length
            int result = 0;
            for (int i = 0; i < arr.length; i++){
                dpList.add(new HashMap<>());
                if (i >= 2){
                    Map<Integer, Integer> curMap = dpList.get(i);
                    Map<Integer, Integer> valueToPosition = new HashMap<>();
                    for (int j = 1; j <= i - 1; j++){
                        valueToPosition.put(arr[j - 1], j - 1);
                        Map<Integer, Integer> jMap = dpList.get(j);
                        if (valueToPosition.containsKey(arr[i] - arr[j]) ) {
                            if (jMap.containsKey(valueToPosition.get(arr[i] - arr[j]) ) ){
                                curMap.put(j, jMap.get(valueToPosition.get(arr[i] - arr[j]) ) + 1);
                                result = Math.max(result, curMap.get(j));
                            }
                            else{
                                curMap.put(j, 3);
                                result = Math.max(result, 3);
                            }
                        }
                    }
                }
            }
            return result;
        }
    }
}