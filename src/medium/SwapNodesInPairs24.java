package medium;

import easy.ListNode;

import java.util.ArrayList;
import java.util.List;

public class SwapNodesInPairs24 {
    public static void main(String[] args) {
        SwapNodesInPairs24 thisClass = new SwapNodesInPairs24();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println (thisClass.swapPairs(node1));
    }
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode toReturn = head.next;
        ListNode current = head;
        ListNode last = null;
        while (current != null && current.next != null){
            ListNode l = current;
            ListNode r = current.next;
            l.next = r.next;
            r.next = l;
            current = l.next;
            if (last == null){
                last = l;
            }
            else{
                last.next = r;
                last = l;
            }
        }
        return toReturn;
    }
}