package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LowestCommonAncestorOfABinaryTreeIII1650 {
    public static void main(String[] args) {
        LowestCommonAncestorOfABinaryTreeIII1650 thisClass = new LowestCommonAncestorOfABinaryTreeIII1650();
    }
    public Node lowestCommonAncestor(Node p, Node q) {
        if (foundInChildren(p, q)){
            return p;
        }
        if (foundInChildren(q, p)){
            return q;
        }
        HashSet<Node> set = new HashSet<Node>();
        return foundInParent(p, q, set);
    }
    private Node foundInParent(Node a, Node b, HashSet<Node> set){
        while(a.parent != null || b.parent != null){
            if (a.parent != null){
                if (set.contains(a.parent)){
                    return a.parent;
                }
                else{
                    set.add(a.parent);
                }
                a = a.parent;
            }
            if (b.parent != null){
                if (set.contains(b.parent)){
                    return b.parent;
                }
                else{
                    set.add(b.parent);
                }
                b = b.parent;
            }
        }
        return null;
    }
    private boolean foundInChildren(Node node, Node target){
        if (node != null){
            if (node.val == target.val){
                return true;
            }
            boolean lNodeFoundTarget = foundInChildren(node.left, target);
            if (lNodeFoundTarget){
                return true;
            }
            boolean rNodeFoundTarget = foundInChildren(node.right, target);
            if (rNodeFoundTarget){
                return true;
            }
        }
        return false;
    }


    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }
}