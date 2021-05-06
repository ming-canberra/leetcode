package medium;

public class ReverseLinkedListII92 {
    public static void main(String[] args) {
        ReverseLinkedListII92 thisClass = new ReverseLinkedListII92();
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
}