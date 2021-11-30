package medium;

import java.util.*;

public class Medium1881MaximumValueafterInsertion {
    class Solution {
        public String maxValue(String n, int x) {
            // n is positive
            if (n.charAt(0) != '-'){
                for (int i = 0; i < n.length(); i++){
                    Integer curInt = Integer.valueOf(n.substring(i, i + 1));
                    // insert x before i
                    if (x > curInt){
                        return n.substring(0, i) + String.valueOf(x) + n.substring(i);
                    }
                }
            }
            // n is negative
            else{
                for (int i = 1; i < n.length(); i++){
                    Integer curInt = Integer.valueOf(n.substring(i, i + 1));
                    // insert x before i
                    if (x < curInt){
                        return n.substring(0, i) + String.valueOf(x) + n.substring(i);
                    }
                }
            }
            // append after the end
            return n + String.valueOf(x);
        }
    }

}