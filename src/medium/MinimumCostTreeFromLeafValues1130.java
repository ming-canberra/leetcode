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
}