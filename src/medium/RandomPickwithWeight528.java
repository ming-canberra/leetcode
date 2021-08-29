package medium;

import java.util.*;

public class RandomPickwithWeight528 {
    class Solution {
        Random random = new Random();
        int sum = 0;
        int[] bin;
        public Solution(int[] w) {
            bin = new int[w.length];
            int tmp = 0;
            for (int i = 0; i < w.length; i++){
                tmp += w[i];
                bin[i] = tmp - 1;
            }
            sum = tmp;
        }
        public int pickIndex() {
            int rValue = random.nextInt(sum);
            int l = -1;
            int r = bin.length;
            while(l + 1 < r){
                int m = (l + r) / 2;
                if (rValue == bin[m]){
                    return m;
                }
                else if (rValue > bin[m]){
                    l = m;
                }
                else if (rValue < bin[m]){
                    r = m;
                }
            }
            return r;
        }
    }
}