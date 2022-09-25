package medium;

public class Medium0092ReverseLinkedListII {
    public static void main(String[] args) {
        Medium0092ReverseLinkedListII thisClass = new Medium0092ReverseLinkedListII();
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (left == right){
            return head;
        }
        ListNode hat = new ListNode();
        hat.next = head;

        ListNode leftNode = head;

        for (int i = 1; i < left; i++){
            hat = hat.next;
            leftNode = leftNode.next;
        }

        ListNode rightNode = leftNode;

        for (int i = left; i < right; i++){
            rightNode = rightNode.next;
            ListNode tmpTail = rightNode.next;
            ListNode tmpHead = hat.next;

            hat.next = rightNode;
            rightNode.next = tmpHead;
            leftNode.next = tmpTail;


            rightNode = leftNode;
        }

        if (left == 1){
            return hat.next;
        }

        return head;
    }

    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {

            ListNode dummyHead = new ListNode();
            dummyHead.next = head;
            ListNode leftPrevious = dummyHead;
            while (left != 1) {
                leftPrevious = leftPrevious.next;
                left--;
            }

            ListNode leftNode = leftPrevious.next;

            ListNode rightNode = dummyHead.next;
            while (right != 1) {
                rightNode = rightNode.next;
                right--;
            }

            ListNode rightNext = rightNode.next; // this can be null
            rightNode.next = null;

            ListNode reversedHead = reverse(leftNode);

            leftPrevious.next = reversedHead;

            leftNode.next = rightNext;

            return dummyHead.next;
        }

        private ListNode reverse(ListNode head) {
            ListNode cur = head;
            ListNode newHead = null;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = newHead;
                newHead = cur;
                cur = next;
            }
            return newHead;
        }
    }

    class Solution1 {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode dummy = new ListNode();
            dummy.next = head;

            ListNode leftBefore = dummy;
            for (int i = 1; i < left; i++) {
                leftBefore = leftBefore.next;
            }
            ListNode leftNode = leftBefore.next;

            ListNode rightNode = dummy;
            for (int i = 0; i < right; i++) {
                rightNode = rightNode.next;
            }

            ListNode rightAfter = rightNode.next;

            leftBefore.next = null;
            rightNode.next = null;
            reverse(leftNode);


            leftBefore.next = rightNode;
            leftNode.next = rightAfter;

            return dummy.next;
        }
        private void reverse(ListNode head) {
            ListNode dummy = new ListNode();
            while(head != null) {
                ListNode dummyNext = dummy.next;
                ListNode curNext = head.next;
                dummy.next = head;
                head.next = dummyNext;
                head = curNext;
            }
        }
    }
}