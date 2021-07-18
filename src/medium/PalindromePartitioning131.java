package medium;

import java.util.*;

public class PalindromePartitioning131 {
    class Solution {
        List<List<String>> result;
        public List<List<String>> partition(String s) {
            result = new ArrayList<>();
            dfs(s, new ArrayList<>());
            return result;
        }
        private void dfs(String s, List<String> list){
            if (s.length() == 0){
                result.add(new ArrayList<>(list));
            }
            else{
                for (int i = 1; i <= s.length(); i++){
                    String first = s.substring(0, i);
                    if (isPal(first)){
                        list.add(first);
                        dfs(s.substring(i), list);
                        list.remove(list.size() - 1);
                    }
                }
            }
        }
        private boolean isPal(String s){
            if (s.length() < 1){
                return false;
            }
            int l = 0;
            int r = s.length() - 1;
            while(l < r){
                if (s.charAt(l) != s.charAt(r)){
                    return false;
                }
                l++;
                r--;
            }
            return true;
        }
    }

}