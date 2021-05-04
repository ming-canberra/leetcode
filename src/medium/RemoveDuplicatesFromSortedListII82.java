package medium;

public class RemoveDuplicatesFromSortedListII82 {
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedListII82 thisClass = new RemoveDuplicatesFromSortedListII82();

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

}