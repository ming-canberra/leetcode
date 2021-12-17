package medium;

public class Medium0926FlipStringtoMonotoneIncreasing {
    class Solution {
        public int minFlipsMonoIncr(String s) {
            int result = Integer.MAX_VALUE;
            int[] leftOneCount = new int[s.length() + 1];
            int[] rightZeroCount = new int[s.length() + 1];
            for (int i = 1; i < s.length() + 1; i++){
                leftOneCount[i] = leftOneCount[i - 1];
                if(s.charAt(i - 1) == '1'){
                    leftOneCount[i]++;
                }
            }
            for (int i = s.length() - 1; i >= 0; i--){
                rightZeroCount[i] = rightZeroCount[i + 1];
                if(s.charAt(i) == '0'){
                    rightZeroCount[i]++;
                }
            }
            for (int i = 0; i < leftOneCount.length; i++){
                result = Math.min(result, leftOneCount[i] + rightZeroCount[i]);
            }
            return result;
        }
    }
}