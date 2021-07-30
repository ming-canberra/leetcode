package medium;

import java.util.ArrayList;
import java.util.List;

public class RotateList61 {
    public static void main(String[] args) {
        RotateList61 thisClass = new RotateList61();
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null){
            return head;
        }
        int length = 0;
        ListNode tmp = head;
        while(tmp != null){
            length++;
            tmp = tmp.next;
        }
        int rotation = k % length;
        if (rotation == 0){
            return head;
        }
        else{
            tmp = head;
            ListNode tail1 = head;
            ListNode tail2 = head.next;
            ListNode head2 = head.next;
            for (int i = 1; i < length - rotation; i++){
                head2 = head2.next;
                tail2 = tail2.next;
                tail1 = tail1.next;
            }
            while(tail2.next != null){
                tail2 = tail2.next;
            }
            tail1.next = null;
            tail2.next = head;
            return head2;
        }
    }

    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null){
                return head;
            }

            ListNode cur = head;
            int length = 0;
            while(cur != null){
                length++;
                cur = cur.next;
            }

            int nth = 0;
            if (k % length == 0){
                return head;
            }
            else{
                nth = k % length;
            }
            //locate second head by locate the nth node from behind
            ListNode fast = head;
            cur = head;
            for (int i = 0; i < nth; i++){
                fast = fast.next;
            }

            while(fast.next != null){
                cur = cur.next;
                fast = fast.next;
            }

            ListNode secondHead = cur.next;
            cur.next = null;


            ListNode tail = secondHead;
            while(tail.next != null){
                tail = tail.next;
            }
            tail.next = head;
            return secondHead;
        }
    }
}