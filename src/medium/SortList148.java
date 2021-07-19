package medium;

public class SortList148 {
    class Solution {
        public ListNode sortList(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }
            ListNode secondHead = cutInHalf(head);
            ListNode sorted1 = sortList(head);
            ListNode sorted2 = sortList(secondHead);
            return merge(sorted1, sorted2);
        }
        private ListNode cutInHalf(ListNode head){
            ListNode slow = head;
            ListNode fast = head.next;
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode result = slow.next;
            slow.next = null;
            return result;
        }
        private ListNode merge(ListNode cur1, ListNode cur2){
            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;
            while(cur1 != null && cur2 != null){
                if(cur1.val < cur2.val){
                    cur.next = cur1;
                    cur = cur.next;
                    cur1 = cur1.next;
                    cur.next = null;
                }
                else{
                    cur.next = cur2;
                    cur = cur.next;
                    cur2 = cur2.next;
                    cur.next = null;
                }
            }
            if(cur1 != null){
                cur.next = cur1;
            }
            if(cur2 != null){
                cur.next = cur2;
            }
            return dummy.next;
        }
    }


    class Solution2 {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null){
                return head;
            }
            ListNode second = getSecondHalfHead(head);// second could be shorter
            ListNode sortedHead = sortList(head);
            ListNode sortedSecond = sortList(second);
            return merge(sortedHead, sortedSecond);
        }

        private ListNode getSecondHalfHead(ListNode head){
            ListNode slow = head;
            ListNode fast = head.next;
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode result = slow.next;
            slow.next = null;
            return result;
        }

        private ListNode merge(ListNode h1, ListNode h2){
            if (h1 == null){
                return h2;
            }
            if (h2 == null){
                return h1;
            }
            ListNode cur1 = h1;
            ListNode cur2 = h2;
            ListNode dummyHead = new ListNode(0);
            ListNode tail = dummyHead;
            while(cur1 != null && cur2 != null){
                ListNode tmp;
                if (cur1.val < cur2.val){
                    tmp = cur1;
                    cur1 = cur1.next;
                }
                else{
                    tmp = cur2;
                    cur2 = cur2.next;
                }
                tmp.next = null;
                tail.next = tmp;
                tail = tmp;
            }
            if (cur1 != null){
                tail.next = cur1;
            }
            if (cur2 != null){
                tail.next = cur2;
            }
            return dummyHead.next;
        }
    }
}

