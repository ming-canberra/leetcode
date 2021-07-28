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
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null){
                return null;
            }
            int lengthA = getLength(headA);
            int lengthB = getLength(headB);
            ListNode shortCurNode;
            ListNode longCurNode;
            if (lengthA < lengthB){
                shortCurNode = headA;
                longCurNode = headB;
            }
            else{
                shortCurNode = headB;
                longCurNode = headA;
            }
            int diff = Math.abs(lengthA - lengthB);
            for (int i = 0; i < diff; i++){
                longCurNode = longCurNode.next;
            }
            while(shortCurNode != null){
                if (shortCurNode == longCurNode){
                    return longCurNode;
                }
                else{
                    shortCurNode = shortCurNode.next;
                    longCurNode = longCurNode.next;
                }
            }
            return null;
        }
        private int getLength(ListNode head){
            int count = 0;
            while(head != null){
                count++;
                head = head.next;
            }
            return count;
        }
    }

    public class SolutionTricky {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null){
                return null;
            }
            ListNode nodeA = headA;
            ListNode nodeB = headB;
            while(nodeA != nodeB){
                if(nodeA == null){
                    nodeA = headB;
                }
                else{
                    nodeA = nodeA.next;
                }
                if(nodeB == null){
                    nodeB = headA;
                }
                else{
                    nodeB = nodeB.next;
                }
            }
            return nodeA;
        }
    }
}