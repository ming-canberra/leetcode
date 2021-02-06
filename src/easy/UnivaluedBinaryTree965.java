package easy;

import java.util.LinkedList;
import java.util.Queue;

public class UnivaluedBinaryTree965 {
    public static void main(String[] args) {
        UnivaluedBinaryTree965 thisClass = new UnivaluedBinaryTree965();
        int[][]input = new int[0][0];

        System.out.println(" " + thisClass.isUnivalTree(null));
    }

    private int _val;

    public boolean isUnivalTree(TreeNode root) {
        _val = root.val;
        return fun(root);
    }
    private boolean fun(TreeNode root){
        if (root == null){
            return true;
        }
        return (root.val ==_val) && fun(root.left) && fun(root.right);
    }
}