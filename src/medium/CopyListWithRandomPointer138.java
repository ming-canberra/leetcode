package medium;

import java.util.*;

public class CopyListWithRandomPointer138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public static void main(String[] args) {
        CopyListWithRandomPointer138 thisClass = new CopyListWithRandomPointer138();
        Node res = thisClass.copyRandomList(null);
        System.out.println(res);
    }

    Map<Node, Node> map = new HashMap<Node, Node>();

    public Node copyRandomList(Node head) {

        if (head == null){
            return null;
        }

        Node newHead;

        if (map.containsKey(head))
        {
            return map.get(head);
        }
        else
        {
            newHead = new Node(head.val);
            map.put(head, newHead);
        }

        newHead.next = copyRandomList(head.next);
        newHead.random = copyRandomList(head.random);

        return newHead;
    }
}