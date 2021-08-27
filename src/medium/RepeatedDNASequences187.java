package medium;

import java.util.*;

public class RepeatedDNASequences187 {
    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            if (s.length() < 10){
                return new ArrayList<>();
            }
            Set<String> set = new HashSet<>();
            Set<String> resultSet = new HashSet<>();
            for (int i = 10; i <= s.length(); i++){
                String cur = s.substring(i - 10, i);
                if (set.contains(cur)){
                    resultSet.add(cur);
                }
                else{
                    set.add(cur);
                }
            }
            return new ArrayList<>(resultSet);
        }
    }
}