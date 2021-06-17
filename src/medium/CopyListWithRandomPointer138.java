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


    class Solution {
        public Node copyRandomList(Node head) {
            Map<Node, Node> oldToNew = new HashMap<>();
            Node curOld = head;
            Node hat = new Node(1);
            Node curNew = hat;
            while (curOld != null){
                Node newNode = new Node(curOld.val);
                curNew.next = newNode;
                oldToNew.put(curOld, newNode);
                curOld = curOld.next;
                curNew = curNew.next;
            }
            // start again from the beginning
            curNew = hat.next;
            curOld = head;
            while (curOld != null)
            {
                if (curOld.random != null){
                    curNew.random = oldToNew.get(curOld.random);
                }
                curOld = curOld.next;
                curNew = curNew.next;
            }
            return hat.next;
        }
    }
}