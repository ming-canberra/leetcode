package easy;

import java.util.*;

public class IntersectionofTwoLinkedLists160 {
    public class SolutionSpaceN {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null){
                return null;
            }
            Set<ListNode> set = new HashSet<>();
            ListNode curA = headA;
            while(curA != null){
                set.add(curA);
                curA = curA.next;
            }
            ListNode curB = headB;
            while(curB != null){
                if (set.contains(curB)){
                    return curB;
                }
                curB = curB.next;
            }
            return null;
        }
    }

}