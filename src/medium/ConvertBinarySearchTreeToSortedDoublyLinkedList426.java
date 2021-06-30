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
}