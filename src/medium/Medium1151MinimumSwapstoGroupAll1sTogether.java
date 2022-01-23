package medium;

import java.util.*;

public class Medium1151MinimumSwapstoGroupAll1sTogether {
    class Solution {
        public int minSwaps(int[] data) {
            int len = data.length;
            int winLen = 0;
            for (int i = 0; i < len; i++){
                if (data[i] == 1){
                    winLen++;
                }
            }
            int zeroCount = 0;
            if (winLen == 0 || winLen == 1){
                return 0;
            }
            int result = winLen;
            int left = 0;
            for (int i = 0; i < len; i++){
                if (data[i] == 0){
                    zeroCount++;
                }
                if (i - left + 1 == winLen){
                    result = Math.min(result, zeroCount);
                    if (data[left] == 0){
                        zeroCount--;
                    }
                    left++;
                }

            }
            return result;
        }
    }

    class Solution1 {
        public int minSwaps(int[] data) {
            int oneCount = 0;
            for (int value : data){
                if (value == 1){
                    oneCount++;
                }
            }
            if (oneCount <= 1 || oneCount == data.length){
                return 0;
            }
            int rlt = oneCount;
            int zeroCount = 0;
            for (int i = 0; i < data.length; i++){
                if (i < oneCount){
                    if (data[i] == 0){
                        zeroCount++;
                    }
                }
                else if (i >= oneCount){
                    if (data[i] == 0){
                        zeroCount++;
                    }
                    if (data[i - oneCount] == 0){
                        zeroCount--;
                    }
                }
                if (i >= oneCount - 1){
                    rlt = Math.min(rlt, zeroCount);
                }
            }
            return rlt;
        }
    }
}