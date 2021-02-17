package easy;

public class LinkedListCycle141 {
    public static void main(String[] args) {
        LinkedListCycle141 thisClass = new LinkedListCycle141();
        thisClass.hasCycle(null);

    }
    public boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }
        ListNode slowHead = head;
        ListNode fastHead = head;
        do
        {
            if(slowHead.next == null
                    || fastHead.next == null
                    || fastHead.next.next == null){
                return false;
            }
            slowHead = slowHead.next;
            fastHead = fastHead.next.next;
        }
        while (slowHead != fastHead);

        return true;
    }
}