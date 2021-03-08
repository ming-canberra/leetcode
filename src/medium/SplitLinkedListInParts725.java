package medium;

import easy.ListNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SplitLinkedListInParts725 {
    public static void main(String[] args) {
        SplitLinkedListInParts725 thisClass = new SplitLinkedListInParts725();

        ListNode l0 = new ListNode(0);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        l0.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        System.out.println(" " + thisClass.splitListToParts(l0, 3));
    }
    public ListNode[] splitListToParts(ListNode root, int k) {


        ListNode head = root;
        int length = 0;

        while (head != null){
            head = head.next;
            length++;
        }
        int quotient = length/k;
        int remainder = length % k;
        ListNode [] toReturn = new ListNode[k];

        head =  root;
        int currentIndex = 0;
        for (int i = 0; i < k; i++){
            if (i < remainder){
                toReturn[i] = head;
                int currentEndIndex = (quotient + 1) * (1 + i);
                while(currentIndex < currentEndIndex - 1) {
                    head = head.next;
                    currentIndex++;
                }
                if (head == null){
                    return toReturn;
                }
                ListNode temp = head.next;
                currentIndex++;
                head.next = null;
                head = temp;
            }
            else{
                toReturn[i] = head;
                int currentEndIndex = ((quotient+1) *remainder ) +quotient * (i+1-remainder);

                while(currentIndex < currentEndIndex - 1) {
                    head = head.next;
                    currentIndex++;
                }
                if (head == null){
                    return toReturn;
                }
                ListNode temp = head.next;
                currentIndex++;
                head.next = null;
                head = temp;
            }
        }

        return toReturn;
    }
}