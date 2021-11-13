package hard;

import java.util.*;

public class Hard0829ConsecutiveNumbersSum {
    class Solution {
        public int consecutiveNumbersSum(int n) {
            int count = 1;
            int N2 = n * 2;
            for(int start = 2; start * start + start <= n * 2; start++){
                // start * (2 * X + start - 1) = n * 2;
                if (N2 % start == 0){
                    if ( (N2 / start + 1 - start) % 2 == 0 ){
                        count++;
                    }
                }
            }
            return count;
        }
    }
}