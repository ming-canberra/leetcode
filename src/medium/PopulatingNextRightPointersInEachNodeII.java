package medium;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeII {
    public static void main(String[] args) {
        PopulatingNextRightPointersInEachNodeII thisClass = new PopulatingNextRightPointersInEachNodeII();

        Node res = thisClass.connect(null);
        System.out.println(res);
    }

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

    public Node connect(Node root) {
        Node cur = root;
        Node headNL = null;
        Node curNL = null;

        while (cur != null){
            // we are at the starting point of the current level
            if (headNL == null){
                if (cur.left != null){
                    headNL = cur.left;
                    curNL = cur.left;
                }
                if (headNL == null){
                    if (cur.right != null){
                        headNL = cur.right;
                        curNL = cur.right;
                    }
                }
                else{
                    if (cur.right != null){
                        curNL.next = cur.right;
                        curNL = curNL.next;
                    }
                }
            }
            else{
                if (cur.left != null){
                    curNL.next = cur.left;
                    curNL = curNL.next;
                }
                if (cur.right != null){
                    curNL.next = cur.right;
                    curNL = curNL.next;
                }
            }
            if (cur.next == null){
                // we are at the end of the current level. Get ready to start a new level
                cur = headNL;
                headNL = null;
                curNL = null;
            }
            else{
                cur = cur.next;
            }
        }
        return root;
    }
}