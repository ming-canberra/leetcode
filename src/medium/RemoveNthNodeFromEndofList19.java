package medium;

import easy.ListNode;

import java.util.ArrayList;
import java.util.List;

public class RemoveNthNodeFromEndofList19 {
    public static void main(String[] args) {
        RemoveNthNodeFromEndofList19 thisClass = new RemoveNthNodeFromEndofList19();
        System.out.println (thisClass.removeNthFromEnd(null, 8));
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List nodeList = new ArrayList<ListNode>();
        ListNode tmp = head;
        while (tmp !=null){
            nodeList.add(tmp);
            tmp = tmp.next;
        }

        if (nodeList.size() -1 - n <0){
            return head.next;
        }

        ListNode nNode = (ListNode) nodeList.get(nodeList.size() - n);
        ListNode nodeBefore = (ListNode) nodeList.get(nodeList.size() -1 - n);
        nodeBefore.next = nNode.next;

        return head;
    }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(1);
            dummy.next = head;
            ListNode left = dummy;
            ListNode right = dummy;
            for (int i = 0; i < n; i++){
                right = right.next;
            }
            while(right.next != null){
                right = right.next;
                left = left.next;
            }
            left.next = left.next.next;
            return dummy.next;
        }
    }
}