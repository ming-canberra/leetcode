package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CountNumberofTeams1395 {
    class Solution {
        public int numTeams(int[] rating) {
            int c1 = count(rating);
            int l = 0;
            int r = rating.length - 1;
            while (l < r){
                int tmp = rating[l];
                rating[l] = rating[r];
                rating[r] = tmp;
                l++;
                r--;
            }
            int c2 = count(rating);
            return c1 + c2;
        }
        private int count(int[] rating){
            int n = rating.length;
            int[] memo = new int[n]; //number of unique sequences with length 2 starting with i index;

            for (int i = 1; i < n - 1; i++){
                int count = 0;
                for (int j = i + 1; j < n; j++){
                    if (rating[i] < rating[j]){
                        count++;
                    }
                }
                memo[i] = count;
            }
            int result = 0;
            for (int i = 0; i < n - 2; i++){
                for (int j = i + 1; j < n - 1; j++){
                    if (rating[i] < rating[j]){
                        result += memo[j];
                    }
                }
            }
            return result;
        }
    }
}