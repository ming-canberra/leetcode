package medium;

import java.util.*;

public class RestoreIPAddresses93 {

    class Solution {
        List<String> result;
        public List<String> restoreIpAddresses(String s) {
            result = new ArrayList<>();
            dfs(s, 0, new ArrayList<>());
            return result;
        }

        private void dfs(String s, int sIndex, List<String> list){
            if (list.size() == 4){
                if(sIndex == s.length()){
                    StringBuilder sb = new StringBuilder();
                    for (String item : list){
                        sb.append(item + ".");
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    result.add(sb.toString());
                }
            }
            else{
                if (sIndex < s.length()){
                    if (s.charAt(sIndex) == '0'){
                        list.add(s.substring(sIndex, sIndex + 1));
                        dfs(s, sIndex + 1, list);
                        list.remove(list.size() - 1);
                    }
                    else{
                        // 1 char
                        if (sIndex < s.length()){
                            list.add(s.substring(sIndex, sIndex + 1));
                            dfs(s, sIndex + 1, list);
                            list.remove(list.size() - 1);
                        }
                        // 2 char
                        if (sIndex < s.length() - 1){
                            list.add(s.substring(sIndex, sIndex + 2));
                            dfs(s, sIndex + 2, list);
                            list.remove(list.size() - 1);
                        }
                        // 3 char
                        if (sIndex < s.length() - 2){
                            String tmp = s.substring(sIndex, sIndex + 3);
                            int tmpInt = Integer.valueOf(tmp);
                            if (tmpInt <= 255){
                                list.add(s.substring(sIndex, sIndex + 3));
                                dfs(s, sIndex + 3, list);
                                list.remove(list.size() - 1);
                            }
                        }
                    }
                }
            }
        }
    }
}