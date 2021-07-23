package medium;

import easy.ListNode;

import java.util.*;

public class ConvertBinarySearchTreeToSortedDoublyLinkedList426 {

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

    class Solution {

        Node head;
        Node tail;

        public Node treeToDoublyList(Node root) {
            if (root == null){
                return null;
            }
            // find the head;
            Node cur = root;

            while(cur.left != null){
                cur = cur.left;
            }
            head = cur;

            // find the tail;
            cur = root;

            while(cur.right != null){
                cur = cur.right;
            }
            tail = cur;


            helper(root);

            head.left = tail;
            tail.right = head;


            return head;
        }

        private void helper(Node root){
            if (root.left != null){
                helper(root.left);
                Node left = getMaxNode(root.left);

                root.left = left;
                left.right = root;
            }
            if (root.right != null){
                helper(root.right);
                Node right = getMinNode(root.right);

                root.right = right;
                right.left = root;
            }
        }

        // get the most right leaf
        private Node getMaxNode(Node root){
            Node cur = root;
            while(cur.right != null){
                cur = cur.right;
            }
            return cur;
        }

        // get the most left leaf
        private Node getMinNode(Node root){
            Node cur = root;
            while(cur.left != null){
                cur = cur.left;
            }
            return cur;
        }

    }


    class Solution2 {

        public Node treeToDoublyList(Node root) {
            if (root == null){
                return null;
            }

            Pair pair = dfs(root);
            Node head = pair.head;
            Node tail = pair.tail;

            head.left = tail;
            tail.right = head;

            return head;
        }

        private Pair dfs(Node root){
            if (root == null){
                return null;
            }

            Pair leftPair = dfs(root.left);

            Pair rightPair = dfs(root.right);

            Node head = root;
            if (leftPair != null){
                head = leftPair.head;
                leftPair.tail.right = root;
                root.left = leftPair.tail;
            }

            Node tail = root;
            if (rightPair != null){
                tail = rightPair.tail;
                rightPair.head.left = root;
                root.right = rightPair.head;
            }

            return new Pair(head, tail);
        }

        class Pair{
            Node head;
            Node tail;
            Pair(Node h, Node t){
                head = h;
                tail = t;
            }
        }
    }

    class Solution3 {
        Node head = null;
        Node tail = null;
        public Node treeToDoublyList(Node root) {
            if (root == null){
                return null;
            }
            recurse(root);
            head.left = tail;
            tail.right = head;
            return head;
        }
        private void recurse(Node root){
            if (root != null){
                recurse(root.left);
                if (tail == null){
                    tail = root;
                    head = root;
                }
                else{
                    tail.right = root;
                    root.left = tail;
                    tail = root;
                }
                recurse(root.right);
            }
        }
    }
}