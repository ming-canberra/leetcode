package hard;

import java.util.*;

public class Hard0140WordBreakII {

    class Solution {
        public List<String> wordBreak(String s, List<String> wordDict) {
            Set<String> set = new HashSet<>(wordDict);

            List<String> result = new ArrayList<>();

            dfs(s, set, result, new ArrayList<>());

            return result;
        }

        private void dfs(String s, Set<String> set, List<String> result, List<String> curList){
            if (s.length() == 0){
                //add it to result
                StringBuilder sb = new StringBuilder();
                for (String word : curList){
                    sb.append(word);
                    sb.append(" ");
                }
                String toAdd = sb.toString();
                result.add(toAdd.substring(0, toAdd.length() - 1));
                return;
            }
            for (int i = 1; i <= s.length(); i++){
                String word = s.substring(0, i);
                if (set.contains(word)){
                    curList.add(word);
                    String rest = s.substring(i);
                    dfs(rest, set, result, curList);
                    curList.remove(curList.size() - 1);
                }
            }
        }
    }


}