package hard;

import java.util.*;

public class MergeKSortedLists23 {
    public static void main(String[] args) {
        MergeKSortedLists23 thisClass = new MergeKSortedLists23();
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(new MyCom());
        ListNode hat = new ListNode(1);
        for (int i = 0; i < lists.length; i++){
            if (lists[i] != null){
                heap.add(lists[i]);
            }
        }
        ListNode prev = hat;
        while(!heap.isEmpty()){
            ListNode curr = heap.poll();
            prev.next = curr;
            if (curr.next != null){
                heap.add(curr.next);
                curr.next = null;
            }
            prev = prev.next;
        }
        return hat.next;
    }
    class MyCom implements Comparator<ListNode> {
        @Override
        public int compare(ListNode a, ListNode b){
            return Integer.compare(a.val, b.val);
        }
    }
}