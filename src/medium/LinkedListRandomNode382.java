package medium;

import easy.ListNode;

import java.util.*;

public class LinkedListRandomNode382 {
    class Solution {

        int length = 0;
        ListNode[] array;
        /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        public Solution(ListNode head) {
            ListNode cur = head;
            while(cur != null){
                length++;
                cur = cur.next;
            }
            array = new ListNode[length];
            cur = head;
            for (int i = 0; i < length; i++){
                array[i] = cur;
                cur = cur.next;
            }
        }

        /** Returns a random node's value. */
        public int getRandom() {
            Random random = new Random();
            int index =  random.nextInt(length);
            return array[index].val;
        }
    }
}