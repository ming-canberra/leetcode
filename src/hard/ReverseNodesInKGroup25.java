package hard;

import java.util.*;

public class ReverseNodesInKGroup25 {
    public static void main(String[] args) {
        ReverseNodesInKGroup25 thisClass = new ReverseNodesInKGroup25();
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
}