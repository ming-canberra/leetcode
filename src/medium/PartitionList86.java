package medium;

public class PartitionList86 {
    public static void main(String[] args) {
        PartitionList86 thisClass = new PartitionList86();
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null){
            return null;
        }
        ListNode headLess = null;
        ListNode tailLess = null;
        ListNode headGreater = null;
        ListNode tailGreater = null;
        while(head != null){
            ListNode curr = head;
            head = head.next;
            curr.next = null;
            if (curr.val < x){
                if (headLess == null){
                    headLess = curr;
                    tailLess = curr;
                }
                else{
                    tailLess.next = curr;
                    tailLess = curr;
                }
            }
            else{
                if (headGreater == null){
                    headGreater = curr;
                    tailGreater = curr;
                }
                else{
                    tailGreater.next = curr;
                    tailGreater = curr;
                }
            }
        }
        ListNode tmp;
        if (tailLess == null)
        {
            return headGreater;
        }
        else{

            tailLess.next = headGreater;
            return headLess;
        }
    }
}