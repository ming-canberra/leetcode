package medium;

import java.util.*;

public class FlattenaMultilevelDoublyLinkedList430 {
    class Solution {
        Queue<Node> q = new LinkedList<>();
        public Node flatten(Node head) {
            if (head == null){
                return null;
            }
            dfs(head);
            Node dummy = new Node();
            Node cur = dummy;
            while(!q.isEmpty()){
                Node top = q.poll();
                cur.next = top;
                top.prev = cur;
                top.child = null;
                cur = top;
            }
            Node result = dummy.next;
            result.prev = null;
            return result;
        }
        private void dfs(Node head){
            while(head != null){
                q.add(head);
                if (head.child != null){
                    dfs(head.child);
                }
                head = head.next;
            }
        }
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
}