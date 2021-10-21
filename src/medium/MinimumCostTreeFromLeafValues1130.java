package medium;

import java.util.*;

public class MinimumCostTreeFromLeafValues1130 {

    /**
     *  O(N*N)
     * */
    class Solution {
        public int mctFromLeafValues(int[] arr) {
            int result = 0;
            int n = arr.length;
            List<Integer> arrList = new ArrayList<>();
            for (int i : arr){
                arrList.add(i);
            }
            for (int i = 1; i < n; i++){
                int min = arrList.get(0);
                int index = 0;
                for (int j = 1; j < arrList.size(); j++){
                    if(arrList.get(j)< min){
                        min = arrList.get(j);
                        index = j;
                    }
                }
                if (index == 0){
                    result += arrList.get(index) * arrList.get(index + 1);
                }
                else if (index == arrList.size() - 1){
                    result += arrList.get(index - 1) * arrList.get(index);
                }
                else{
                    result += arrList.get(index) * Math.min(arrList.get(index + 1), arrList.get(index - 1));
                }
                arrList.remove(index);
            }
            return result;
        }
    }
    /**
     *  O(N*N*N)
     * */
    class Solution1 {
        int[][][] memo;
        public int mctFromLeafValues(int[] arr) {
            int len = arr.length;
            memo = new int[len][len][2];// 0th to store sum, 1th to store max leaf value
            int[] result = minSum(arr, 0, len - 1);
            return result[0];
        }
        private int[] minSum(int[] arr, int start, int end){
            if (start == end){
                memo[start][end][0] = 0;
                memo[start][end][1] = arr[end];
                return memo[start][end];
            }
            if (memo[start][end][0] != 0){
                return memo[start][end];
            }
            int minResult = Integer.MAX_VALUE;
            int maxValue = arr[start];
            for (int i = 0; i < end - start; i++){
                int[] aResult = minSum(arr, start, start + i);
                int[] bResult = minSum(arr, start + i + 1, end);
                minResult = Math.min(minResult, aResult[0] + bResult[0] + aResult[1] * bResult[1]);
                maxValue = Math.max(aResult[1], bResult[1] );
            }
            memo[start][end][0] = minResult;
            memo[start][end][1] = maxValue;
            return memo[start][end];
        }
    }
}