package medium;

public class Medium0082RemoveDuplicatesFromSortedListII {
    public static void main(String[] args) {
        Medium0082RemoveDuplicatesFromSortedListII thisClass = new Medium0082RemoveDuplicatesFromSortedListII();

        System.out.println (thisClass.deleteDuplicates(null));
    }

    public ListNode deleteDuplicates(ListNode head) {

        ListNode hat = new ListNode(-999);
        hat.next = head;

        ListNode sorted = hat;
        ListNode left = hat;
        ListNode right = head;

        while(right != null)
        {
            // duplicates starting
            if(left.val == right.val)
            {
                right = right.next;
            }
            else{
                // duplicates ending
                if (left.next != right)
                {
                    sorted.next = right;
                    left = right;
                    right = right.next;
                }
                // no duplicates within the sliding window
                else{
                    sorted = left;
                    left = left.next;
                    right = right.next;
                }
            }

            // sliding window is open, work to do before breaking out
            if (right == null)
            {
                if (left.next != right){
                    sorted.next = null;
                }
            }
        }

        return hat.next;
    }

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode tail = dummy;
            ListNode left = dummy.next;
            ListNode right = dummy.next;
            while(left != null) {
                while(right != null && left.val == right.val) {
                    right = right.next;
                }
                if (right == null) {
                    if (left.next != null) {
                        tail.next = null;
                    }
                    break;
                }
                else {
                    if (left.next == right) {
                        tail = tail.next;
                    }
                    else {
                        tail.next = right;
                    }
                    left = right;
                }
            }
            return dummy.next;
        }
    }
}