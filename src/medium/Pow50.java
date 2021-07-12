package medium;

import java.util.Arrays;

public class Pow50 {
    class Solution {
        public double myPow(double x, int n) {
            if (x == 0.0){
                return 0.0;
            }
            if (n == 0){
                return 1;
            }

            if (n % 2 == 0){
                double tmp = myPow(x, n/2);
                return tmp * tmp;
            }
            else{
                if (n < 0){
                    return 1.0 / x * myPow(x, n + 1);
                }
                else{
                    return x * myPow(x, n - 1);
                }
            }
        }
    }
}