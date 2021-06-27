package medium;

public class ReorderList143 {
    public static void main(String[] args) {
        ReorderList143 thisClass = new ReorderList143();

    }

    public void reorderListSecondTime(ListNode head) {
        if (head.next != null){
            ListNode headSecond = splitAndReturnSecondHead(head);
            headSecond = revert(headSecond);
            merge(head, headSecond);
        }
    }
    private ListNode splitAndReturnSecondHead(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        ListNode slowPrev = slow;
        while(fast != null && fast.next != null){
            slowPrev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null){
            slowPrev = slow;
            slow = slow.next;
        }
        // split
        slowPrev.next = null;
        return slow;
    }
    private ListNode revert(ListNode head){
        ListNode curr = head;
        ListNode next = head.next;
        head.next = null;
        while(next != null){
            curr = next;
            next = next.next;
            curr.next = head;
            head = curr;
        }
        return curr;
    }
    /*
            1->2->3  6->5->4
            1->2->3  5->4
    */
    private void merge(ListNode head, ListNode headSecond){
        ListNode lFirst = head;
        ListNode lSecond = headSecond;
        ListNode currFirst;
        ListNode currSecond;
        while(lFirst != null){
            currFirst = lFirst;
            lFirst = lFirst.next;

            currSecond = lSecond;
            if (lSecond != null){
                lSecond = lSecond.next;
                currFirst.next = currSecond;
                currSecond.next = lFirst;
            }
        }
    }

    public void reorderListFirstTime(ListNode head) {

        if (head.next == null){
            return;
        }

        ListNode headR = splitAndGetReversedHead(head);

        ListNode lInOrder = head;
        ListNode rInOrder = head.next;

        ListNode lReversed = headR;
        ListNode rReversed = headR.next;

        while(lInOrder != null){
            rInOrder = lInOrder.next;
            if (lReversed == null){
                break;
            }
            rReversed = lReversed.next;

            lInOrder.next = lReversed;
            lReversed.next = rInOrder;

            lInOrder = rInOrder;
            lReversed = rReversed;
        }
    }

    private ListNode splitAndGetReversedHead(ListNode head){

        ListNode tmp = head;
        int size = 0;
        while(tmp != null){
            size++;
            tmp = tmp.next;
        }
        // get the head of the second half.
        ListNode headR = head;
        tmp = headR;
        for(int i = 1; i <= size / 2; i++){
            tmp = headR;
            headR = headR.next;
            if (i == size / 2 && size % 2 == 1)
            {
                tmp = headR;
                headR = headR.next;
            }
        }
        // split it into two
        tmp.next = null;

        System.out.println(headR.val);
        // reverse headR
        ListNode cur = headR;
        ListNode next = headR.next;
        cur.next = null;
        while (next != null){
            cur = next;
            next = next.next;
            cur.next = headR;
            headR = cur;
        }

        return cur;
    }

    class Solution {
        public void reorderList(ListNode head) {
            if(head == null || head.next == null){
                return;
            }
            // find the length
            int n = 0;
            ListNode tmp = head;
            while(tmp != null){
                n++;
                tmp = tmp.next;
            }

            ListNode tailFirstHalf = head;
            int index = 1;
            while(index < (n + 1) / 2){
                tailFirstHalf = tailFirstHalf.next;
                index++;
            }

            ListNode headSecondHalf = tailFirstHalf.next;
            tailFirstHalf.next = null;

            headSecondHalf = revert(headSecondHalf);

            merge(head, headSecondHalf);
        }

        // revert a list and return new head
        private ListNode revert(ListNode head){
            ListNode prev = null;
            ListNode cur = head;
            ListNode next = null;

            while(cur != null){
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }

            return prev;
        }
        // merge second list into first list
        private void merge(ListNode node1, ListNode node2){
            ListNode cur1 = node1;
            ListNode cur2 = node2;
            ListNode next1 = null;
            ListNode next2 = null;
            while(cur1 != null && cur2 != null){
                next1 = cur1.next;
                next2 = cur2.next;
                cur1.next = cur2;
                cur2.next = next1;

                cur1 = next1;
                cur2 = next2;
            }
        }
    }
}