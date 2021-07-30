package medium;

import java.util.LinkedList;
import java.util.Queue;

public class InsertintoaSortedCircularLinkedList708 {
    class Solution {
        public Node insert(Node head, int insertVal) {
            Node newNode = new Node(insertVal);
            if (head == null){
                newNode.next = newNode;
                return newNode;
            }
            Node prev = head;
            Node cur = head.next;
            if (prev == cur){
                newNode.next = prev;
                prev.next = newNode;
                return head;
            }
            else{
                Node smallest = head;
                Node biggest = head;
                while(cur != head){
                    if (cur.val > biggest.val){
                        biggest = cur;
                    }
                    if (cur.val < smallest.val){
                        smallest = cur;
                    }
                    cur = cur.next;
                }
                if (smallest.val == biggest.val){
                    Node next = head.next;
                    head.next = newNode;
                    newNode.next = next;
                }
                else{
                    cur = biggest.next;
                    while(cur.val == biggest.val){
                        biggest = cur;
                        cur = cur.next;
                    }
                    smallest = cur;
                    if (insertVal <= smallest.val || insertVal >= biggest.val){
                        Node next = biggest.next;
                        biggest.next = newNode;
                        newNode.next = next;
                    }
                    else{
                        prev = smallest;
                        cur = smallest.next;
                        while(cur != biggest.next){
                            if (insertVal >= prev.val && insertVal < cur.val){
                                prev.next = newNode;
                                newNode.next = cur;
                                break;
                            }
                            prev = cur;
                            cur = cur.next;
                        }
                    }
                }
            }
            return head;
        }
    }

    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    };
}