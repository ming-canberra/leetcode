package medium;

import java.util.*;

public class OddEvenLinkedList328 {
    class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null || head.next == null){
                return head;
            }

            ListNode oddH = head;
            ListNode oddT = head;

            ListNode evenH = head.next;
            ListNode evenT = head.next;

            ListNode cur = head.next.next;
            int counter = 3;
            while(cur != null){
                // odd
                if (counter % 2 == 1){
                    oddT.next = cur;
                    oddT = cur;
                }
                // even
                else{
                    evenT.next = cur;
                    evenT = cur;
                }
                counter++;
                cur = cur.next;
            }

            oddT.next = evenH;
            evenT.next = null;

            return oddH;
        }
    }
}