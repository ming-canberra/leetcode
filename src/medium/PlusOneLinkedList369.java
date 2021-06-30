package medium;

import easy.ListNode;

import java.util.*;

public class PlusOneLinkedList369 {

    class Solution {
        public ListNode plusOne(ListNode head) {
            if (head == null){
                return null;
            }
            Stack<ListNode> stack = new Stack<>();
            ListNode cur = head;
            while(cur != null){
                stack.push(cur);
                cur = cur.next;
            }
            int carry = 0;
            boolean firstTime = true;
            while(!stack.isEmpty()){
                ListNode top = stack.pop();
                int newValue;
                if (firstTime){
                    newValue = top.val + 1 + carry;
                    firstTime = false;
                }
                else{
                    newValue = top.val + carry;
                }

                top.val = newValue % 10;
                carry = newValue / 10;
            }

            if (carry > 0){
                ListNode newHead = new ListNode(carry);
                newHead.next = head;
                return newHead;
            }
            else{
                return head;
            }
        }
    }
}