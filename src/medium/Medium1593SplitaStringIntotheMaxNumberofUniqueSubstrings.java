package medium;

import java.util.*;

public class Medium1593SplitaStringIntotheMaxNumberofUniqueSubstrings {
    class Solution {
        int result = 1;
        public int maxUniqueSplit(String s) {
            Set<String> set = new HashSet<>();
            backtrack(s, set);
            return result;
        }
        private void backtrack(String curString, Set<String> set){
            int len = curString.length();
            if (len == 0){
                result = Math.max(result, set.size());
                return;
            }
            for (int i = 1; i <= len; i++){
                String left = curString.substring(0, i);
                String right = curString.substring(i, len);
                if (set.contains(left)){
                    continue;
                }
                else{
                    set.add(left);
                    backtrack(right, set);
                    set.remove(left);
                }
            }
        }
    }
}