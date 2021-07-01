package medium;

public class InsertionSortList147 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode insertionSortList(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }

            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode sortedTail = head;

            ListNode cur = null;

            while(sortedTail.next != null){
                // extract cur from the list
                cur = sortedTail.next;
                sortedTail.next = cur.next;
                cur.next = null;

                // iterate from dummy.next to sortedTail
                ListNode sortedCur = dummy;
                while(sortedCur.next != sortedTail){
                    if (cur.val <= sortedCur.next.val){
                        cur.next = sortedCur.next;
                        sortedCur.next = cur;
                        cur = null;
                        break;
                    }
                    else{
                        sortedCur = sortedCur.next;
                    }
                }
                if (cur != null){
                    // we are right before the sortedTail
                    if (cur.val <= sortedCur.next.val){
                        sortedCur.next = cur;
                        cur.next = sortedTail;
                    }
                    // new sortedTail found
                    else{
                        cur.next = sortedTail.next;
                        sortedTail.next = cur;
                        sortedTail = cur;
                    }
                }
            }

            return dummy.next;
        }
    }

    class Solution2 {
        public ListNode insertionSortList(ListNode head) {
            ListNode dummy = new ListNode(0);
            while(head != null){
                ListNode next = head.next;
                head.next = null;
                if (dummy.next == null){
                    dummy.next = head;
                }
                else{
                    ListNode prev = dummy;
                    ListNode cur = dummy.next;
                    while(cur != null && head.val > cur.val){
                        prev = cur;
                        cur = cur.next;
                    }
                    prev.next = head;
                    head.next = cur;
                }
                head = next;
            }
            return dummy.next;
        }
    }
}