package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        ValidateBinarySearchTree thisClass = new ValidateBinarySearchTree();

        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node2.left = node1;
        node2.right = node3;

        boolean res = thisClass.isValidBST(node2);
        System.out.println(res);
    }

    public boolean isValidBST(TreeNode root) {
        return isValid(root.left, Long.MIN_VALUE, root.val) && isValid(root.right, root.val, Long.MAX_VALUE);
    }

    /**
    * value of node must be greater than min AND less than max
    * */
    private boolean isValid(TreeNode node, long min, long max){
        if (node == null){
            return true;
        }
        if (node.val <= min || node.val >= max){
            return false;
        }
        return isValid(node.left, min, Math.min(max, node.val))
                && isValid(node.right, Math.max(min, node.val), max);
    }
}