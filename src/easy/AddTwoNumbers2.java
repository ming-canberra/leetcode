package easy;

public class AddTwoNumbers2 {
    public static void main(String[] args) {
        AddTwoNumbers2 thisClass = new AddTwoNumbers2();
        System.out.println(" " + thisClass.addTwoNumbers2(null, null));
    }
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        ListNode currentNode= new ListNode();
        ListNode toReturn = currentNode;
        boolean carry = false;
        while(l1 != null || l2 != null){
            int int1 = 0;
            int int2 = 0;
            if (l1 != null){
                int1 = l1.val;
            }
            if (l2 != null){
                int2 = l2.val;
            }
            int sum = 0;
            if (carry){
                sum = int1 + int2 +1;
            }
            else{
                sum = int1 + int2;
            }

            carry = sum / 10 > 0;
            currentNode.next = new ListNode(sum % 10);
            currentNode = currentNode.next;
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }

        if (carry){
            currentNode.next = new ListNode(1);
        }

        return toReturn.next;
    }



    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        fun(l1, l2, result, false);
        return result.next;
    }
    private void fun(ListNode l1, ListNode l2, ListNode result, boolean carry){
        int int1 = 0;
        if (l1 != null){
            int1 = l1.val;
        }

        int int2 = 0;
        if (l2 != null){
            int2 = l2.val;
        }

        int sum =0;

        if (carry){
            sum = 1 + int1 + int2;
        }
        else{
            sum = int1 + int2;
        }

        if (l1 == null && l2 == null){
            if (sum > 0){
                ListNode currentResult = new ListNode(sum);
                result.next = currentResult;
            }
            return;
        }
        else{
            boolean resultCarry = sum > 9;
            ListNode currentResult = new ListNode(sum % 10);
            result.next = currentResult;
            ListNode l1Next;
            ListNode l2Next;
            if (l1 == null){
                l1Next = null;
            }
            else{
                l1Next = l1.next;
            }
            if (l2 == null){
                l2Next = null;
            }
            else{
                l2Next = l2.next;
            }
            fun(l1Next, l2Next, currentResult, resultCarry);
        }
    }
}