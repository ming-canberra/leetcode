package medium;

import java.util.*;

public class Medium0133CloneGraph {
    class Solution {
        public Node cloneGraph(Node node) {
            if (node == null) {
                return null;
            }
            Map<Integer, Node> oldNewMap = new HashMap<>();
            Queue<Node> queue = new LinkedList<>();
            queue.add(node);
            oldNewMap.put(node.val, new Node(node.val));

            Set<Node> visited = new HashSet<>();
            while(!queue.isEmpty()) {
                Node top = queue.poll();
                if (visited.contains(top)) {
                    continue;
                }
                visited.add(top);


                Node copy = oldNewMap.getOrDefault(top.val, new Node(top.val));
                oldNewMap.put(top.val, copy);


                for (Node oldNb : top.neighbors) {
                    if (!oldNewMap.containsKey(oldNb.val)){
                        Node newNb = new Node(oldNb.val);
                        oldNewMap.put(oldNb.val, newNb);
                    }
                    copy.neighbors.add(oldNewMap.get(oldNb.val));
                    queue.add(oldNb);
                }
            }
            return oldNewMap.get(node.val);
        }
    }

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}