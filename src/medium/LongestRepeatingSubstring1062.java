package medium;

import java.util.*;

public class LongestRepeatingSubstring1062 {
    public static void main(String[] args) {
        LongestRepeatingSubstring1062 thisClass = new LongestRepeatingSubstring1062();
    }
    /**
     * O(N*NlogN)
     * */
    public int longestRepeatingSubstring(String s) {
        int l = -1;
        int r = s.length();
        while (l + 1 < r){
            int m = l + (r - l) / 2;
            if (!hasRepeatingSubstring(s, m)){
                r = m;
            }
            else{
                l = m;
            }
        }
        return l;
    }
    private boolean hasRepeatingSubstring(String s, int n){
        if (n == 0){
            return true;
        }
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i <= s.length() - n;i++ ){
            String sub = s.substring(i, i + n);
            if (set.contains(sub)){
                return true;
            }
            else{
                set.add(sub);
            }
        }
        return false;
    }
}