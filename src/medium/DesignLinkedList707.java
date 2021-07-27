package medium;

public class DesignLinkedList707 {
    class MyLinkedList {

        Node dummy;
        /** Initialize your data structure here. */
        public MyLinkedList() {
            dummy = new Node(0);
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            if (index < 0){
                return -1;
            }
            int cur = 0;
            Node curNode = dummy.next;
            while(cur < index && curNode != null){
                cur++;
                curNode = curNode.next;
            }
            if (curNode == null){
                return -1;
            }
            else{
                return curNode.val;
            }
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            Node head = new Node(val);
            head.next = dummy.next;
            dummy.next = head;
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            Node tail = new Node(val);
            Node cur = dummy;
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = tail;
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if (index < 0){
                return;
            }
            int cur = 0;
            Node curNode = dummy.next;
            Node prevNode = dummy;
            while(cur < index && curNode != null){
                cur++;
                curNode = curNode.next;
                prevNode = prevNode.next;
            }
            if (curNode == null){
                if (cur == index){
                    prevNode.next = new Node(val);
                }
            }
            else{
                Node newNode = new Node(val);
                newNode.next = curNode;
                prevNode.next = newNode;
            }
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if (index < 0){
                return;
            }
            int cur = 0;
            Node curNode = dummy.next;
            Node prevNode = dummy;
            while(cur < index && curNode != null){
                cur++;
                curNode = curNode.next;
                prevNode = prevNode.next;
            }
            if (curNode == null){
                return;
            }
            else{
                prevNode.next = curNode.next;
            }
        }

        class Node{
            int val;
            Node next;
            public Node(int v){
                val = v;
            }
        }
    }
}