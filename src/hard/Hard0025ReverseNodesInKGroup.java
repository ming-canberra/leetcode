package hard;

import java.util.*;

public class Hard0025ReverseNodesInKGroup {
    public static void main(String[] args) {
        Hard0025ReverseNodesInKGroup thisClass = new Hard0025ReverseNodesInKGroup();
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1){
            return head;
        }
        // chop it up into length k chunks
        // this list contains all list with k length, a.k.a, chunk
        List<ListNode> nodesList = new ArrayList<>();

        int kCounter = 0;
        ListNode startingNode = head;
        while(head != null){
            kCounter++;
            ListNode cur = head;
            head = head.next;
            if (kCounter == k){
                kCounter = 0;
                nodesList.add(startingNode);
                cur.next = null;
                startingNode = head;
            }
        }
        List<ListNode> newHeadsList = new ArrayList<>();
        for (int i = 0; i < nodesList.size(); i++){
            newHeadsList.add(revertAndReturnNewHead(nodesList.get(i)));
        }

        for (int i = 0; i < nodesList.size() - 1; i++){
            nodesList.get(i).next = newHeadsList.get(i + 1);
        }

        nodesList.get(nodesList.size() - 1).next = startingNode;

        return newHeadsList.get(0);
    }
    private ListNode revertAndReturnNewHead(ListNode head){
        ListNode lHead = head;
        ListNode cur = null;
        while(lHead != null){
            ListNode tmp = lHead;
            lHead = lHead.next;
            tmp.next = cur;
            cur = tmp;
        }
        return cur;
    }

    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (k == 1){
                return head;
            }
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode cur = head;
            ListNode curGroupHead = cur;
            ListNode lastGroupTail = dummy;
            int counter = k;
            while(cur != null && cur.next != null){
                counter--;
                cur = cur.next;
                ListNode tmp = cur.next;
                if (counter == 1){
                    lastGroupTail.next = null;
                    cur.next = null;
                    reverse(curGroupHead);
                    curGroupHead.next = tmp;
                    lastGroupTail.next = cur;
                    cur = tmp;
                    lastGroupTail = curGroupHead;
                    curGroupHead = cur;
                    counter = k;
                }
            }
            return dummy.next;
        }
        private void reverse(ListNode head){
            ListNode cur = head;
            ListNode newHead = null;
            while(cur != null){
                ListNode curNext = cur.next;
                cur.next = newHead;
                newHead = cur;
                cur = curNext;
            }
        }
    }
}