package medium;

import java.util.*;

public class Medium0362DesignHitCounter {
    class HitCounter {
        ListNode head = null;
        public HitCounter() {
        }
        public void hit(int timestamp) {
            if (head == null){
                head = new ListNode(1, null, timestamp);
            }
            else{
                if (head.timestamp == timestamp){
                    head.count++;
                }
                else{
                    ListNode newHead = new ListNode(1, head, timestamp);
                    head = newHead;
                }
            }
        }
        public int getHits(int timestamp) {
            int sum = 0;
            ListNode cur = head;
            while(cur != null){
                if (cur.timestamp + 299 >= timestamp){
                    sum += cur.count;
                }
                else{
                    break;
                }
                cur = cur.prev;
            }
            return sum;
        }
        class ListNode{
            int count = 0;
            ListNode prev = null;
            int timestamp = 0;
            public ListNode(int c, ListNode p, int time){
                count = c;
                prev = p;
                timestamp = time;
            }
        }
    }
}