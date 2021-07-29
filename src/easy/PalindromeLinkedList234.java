package easy;

import java.util.*;

public class PalindromeLinkedList234 {
    public static void main(String[] args) {
        PalindromeLinkedList234 thisClass = new PalindromeLinkedList234();
        boolean df = thisClass.isPalindrome(null);
        System.out.println(df);
    }
    public boolean isPalindrome(ListNode head) {

        int length = 0;

        ListNode tempHead = head;

        while (tempHead != null){
            tempHead = tempHead.next;
            length++;
        }

        if (length % 2 == 0){
            tempHead = head;

            int currentIndex = 0;
            ListNode currentNode = head;
            while (currentIndex < length/2 - 1){
                currentIndex++;
                currentNode = currentNode.next;
            }
            ListNode secondHead = currentNode.next;
            currentNode.next = null;

            // revert secondHead
            secondHead = revertListNode(secondHead);

            // compare tempHead and secondHead
            return compare(tempHead, secondHead);
        }
        else{
            if (length == 1){
                return true;
            }
            tempHead = head;

            int currentIndex = 0;
            ListNode currentNode = head;
            while (currentIndex < length/2 - 1){
                currentIndex++;
                currentNode = currentNode.next;
            }
            ListNode secondHead = currentNode.next.next;
            currentNode.next = null;

            // revert secondHead
            secondHead = revertListNode(secondHead);

            // compare tempHead and secondHead
            return compare(tempHead, secondHead);
        }
    }

    private ListNode revertListNode(ListNode head){
        ListNode reorderedHead = null;

        while (head != null){

            ListNode currentOne = head;

            head = head.next;

            currentOne.next = reorderedHead;
            reorderedHead = currentOne;
        }
        return reorderedHead;
    }
    private boolean compare(ListNode first, ListNode second){
        while (first !=null || second != null){
            if (first == null && second != null){
                return false;
            }
            else if (second == null && first != null){
                return false;
            }
            else if (first.val != second.val){
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return true;
    }
    class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null){
                return true;
            }
            Stack<Integer> stack = new Stack<>();
            ListNode slow = head;
            ListNode fast = head.next;
            while(fast != null && fast.next != null){
                stack.push(slow.val);
                slow = slow.next;
                fast = fast.next.next;
            }
            if (fast != null){
                stack.push(slow.val);
            }
            ListNode secondHalfHead = slow.next;
            while(!stack.isEmpty()){
                Integer top = stack.pop();
                if (secondHalfHead.val != top){
                    return false;
                }
                secondHalfHead = secondHalfHead.next;
            }
            return true;
        }
    }
}