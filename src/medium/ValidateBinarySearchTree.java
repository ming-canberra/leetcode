package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ValidateBinarySearchTree {
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

    class Solution {
        public boolean isValidBST(TreeNode root) {
            return isValid(root, null, null);
        }
        private boolean isValid(TreeNode node, Integer low, Integer high){
            if (node == null){
                return true;
            }
            if (high != null && node.val >= high){
                return false;
            }
            if (low != null && node.val <= low){
                return false;
            }
            boolean leftValid = isValid(node.left, low, node.val);
            boolean rightValid = isValid(node.right, node.val, high);
            return leftValid && rightValid;
        }
    }
}