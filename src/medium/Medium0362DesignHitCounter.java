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


    class HitCounter1 {
        Deque<int[]> deque; // 0th for timestamp,  1th for number of hits
        int hitsSum = 0;
        public HitCounter1() {
            deque = new LinkedList<>();
        }
        public void hit(int timestamp) {
            if (deque.size() == 0){
                deque.addFirst( new int[]{timestamp, 1} );
                hitsSum++;
            }
            else{
                if (deque.peekFirst()[0] == timestamp){
                    deque.peekFirst()[1]++;
                    hitsSum++;
                }
                else{
                    deque.addFirst( new int[]{timestamp, 1} );
                    hitsSum++;
                }
                while(!deque.isEmpty() && deque.peekLast()[0] + 300 <= timestamp){
                    hitsSum -= deque.peekLast()[1];
                    deque.pollLast();
                }
            }
        }
        public int getHits(int timestamp) {
            if (deque.size() == 0){
                return 0;
            }
            while(!deque.isEmpty() && deque.peekLast()[0] + 300 <= timestamp){
                hitsSum -= deque.peekLast()[1];
                deque.pollLast();
            }
            return hitsSum;
        }
    }
}