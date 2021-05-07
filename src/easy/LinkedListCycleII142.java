package easy;

public class LinkedListCycleII142 {
    public static void main(String[] args) {
        LinkedListCycleII142 thisClass = new LinkedListCycleII142();
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode nodeSlow = head.next;
        ListNode nodeFast = head.next.next;
        while(nodeSlow != null && nodeFast != null && nodeFast.next != null){
            if (nodeSlow == nodeFast){
                break;
            }
            nodeSlow = nodeSlow.next;
            nodeFast = nodeFast.next.next;
        }
        if (nodeFast == null || nodeFast.next == null){
            return null;
        }
        else{
            ListNode result = head;
            while(result != nodeSlow){
                result = result.next;
                nodeSlow = nodeSlow.next;
            }
            return result;
        }
    }
}