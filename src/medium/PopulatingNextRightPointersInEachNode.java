package medium;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
    public static void main(String[] args) {
        PopulatingNextRightPointersInEachNode thisClass = new PopulatingNextRightPointersInEachNode();

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
        //BFS
        if (root == null){
            return null;
        }
        Queue<Node> q1 = new LinkedList<Node>();
        q1.add(root);
        Queue<Node> q2 = new LinkedList<Node>();
        recursiveFun(q1, q2);
        return root;
    }

    private void recursiveFun(Queue<Node> qA, Queue<Node> qB){
        if (qA.isEmpty() && qB.isEmpty()){
            return;
        }
        else if (qB.isEmpty()){
            setNextHelper(qA, qB);
        }
        else{
            setNextHelper(qB, qA);
        }
    }

    private void setNextHelper(Queue<Node> q1, Queue<Node> q2){
        Node current = null;
        while(!q1.isEmpty()){
            Node topOne = q1.poll();
            if (current == null){
                current = topOne;
            }
            else{
                current.next = topOne;
                current = topOne;
            }
            if (q1.size() == 0){
                topOne.next = null;
            }
            if (topOne.left != null){
                q2.add(topOne.left);
                q2.add(topOne.right);
            }
        }
        recursiveFun(q1, q2);
    }

}