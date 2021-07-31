package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InsertintoaBinarySearchTree701 {
    class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null){
                return new TreeNode(val);
            }
            else{
                traverse(root, val);
                return root;
            }
        }
        private void traverse(TreeNode root, int val){
            if (root.val < val){
                if (root.right == null){
                    root.right = new TreeNode(val);
                }
                else{
                    traverse(root.right, val);
                }
            }
            else{
                if (root.left == null){
                    root.left = new TreeNode(val);
                }
                else{
                    traverse(root.left, val);
                }
            }
        }
    }
}