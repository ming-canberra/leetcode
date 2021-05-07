package easy;

public class ReverseLinkedList206 {
    public static void main(String[] args) {
        ReverseLinkedList206 thisClass = new ReverseLinkedList206();
    }
    public ListNode reverseList(ListNode head) {
        if (head == null){
            return null;
        }
        return reverse(head, head, head.next);
    }
    private ListNode reverse(ListNode head, ListNode tail, ListNode curr){
        if (curr == null){
            return head;
        }
        tail.next = curr.next;
        curr.next = head;
        return reverse(curr, tail, tail.next);
    }
}