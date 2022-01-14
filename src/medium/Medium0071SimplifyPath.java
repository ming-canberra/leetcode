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

    class Solution1 {
        public String simplifyPath(String path) {

            Stack<String> stack = new Stack<>();
            String[] chunks = path.split("/");
            for (String chunk : chunks){
                if (".".equals(chunk)){
                    continue;
                }
                else if ("..".equals(chunk)){
                    if (!stack.isEmpty()){
                        stack.pop();
                    }
                }
                else if ("".equals(chunk)){
                    continue;
                }
                else{
                    stack.push(chunk);
                }
            }

            List<String> list = new ArrayList<>(stack);

            if (list.size() == 0){
                return "/";
            }
            StringBuilder sb = new StringBuilder();

            for (String s : list){
                sb.append("/");
                sb.append(s);
            }
            return sb.toString();
        }
    }
}