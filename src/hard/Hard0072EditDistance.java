package hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Hard0072EditDistance {
    class Solution {
        int[][] memo;
        public int minDistance(String word1, String word2) {
            memo = new int[word1.length()][word2.length()];

            for (int i = 0; i < word1.length(); i++){
                for (int j = 0; j < word2.length(); j++){
                    memo[i][j] = -1;
                }
            }

            return recurse(word1, word2, 0, 0);
        }
        private int recurse(String word1, String word2, int idx1, int idx2){
            int len1 = word1.length();
            int len2 = word2.length();
            if (idx1 == len1){
                return len2 - idx2;
            }
            else if (idx2 == len2){
                return len1 - idx1;
            }
            else{
                if (memo[idx1][idx2] != -1){
                    return memo[idx1][idx2];
                }

                if ( word1.charAt(idx1) == word2.charAt(idx2) ){
                    return recurse(word1, word2, idx1 + 1, idx2 + 1);
                }
                else{
                    // insert onto current position at word1
                    int insert = recurse(word1, word2, idx1, idx2 + 1);
                    int replace = recurse(word1, word2, idx1 + 1, idx2 + 1);
                    // delete current position at word1
                    int delete = recurse(word1, word2, idx1 + 1, idx2);
                    int result = 1 + Math.min( Math.min(insert, replace), delete );
                    memo[idx1][idx2] = result;
                    return memo[idx1][idx2];
                }
            }
        }
    }
}