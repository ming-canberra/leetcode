package medium;

import java.util.*;

public class Medium0071SimplifyPath {
    class Solution {
        public String simplifyPath(String path) {
            String[] chunks = path.split("/");
            Deque<String> deque = new LinkedList<>();
            for (String ss : chunks){
                if (ss.equals(".")){
                    continue;
                }
                else if (ss.equals("")){
                    continue;
                }
                else if (ss.equals("..")){
                    if (!deque.isEmpty()){
                        deque.pollLast();
                    }
                }
                else{
                    deque.addLast(ss);
                }
            }
            StringBuilder sb = new StringBuilder();
            while(!deque.isEmpty()){
                sb.append("/");
                sb.append(deque.pollFirst());
            }
            if (sb.length() == 0){
                return "/";
            }
            else{
                return sb.toString();
            }
        }
    }
}