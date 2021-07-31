package medium;

import java.util.*;

public class DeleteNodeinaBST450 {
    class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null){
                return null;
            }
            if (root.val < key){
                root.right = deleteNode(root.right, key);
            }
            else if (root.val > key){
                root.left = deleteNode(root.left, key);
            }
            else{
                if (root.left == null)
                {
                    return root.right;
                }
                else if (root.right == null){
                    return root.left;
                }
                else{
                    TreeNode next = findNext(root.right);
                    root.val = next.val;
                    root.right = deleteNode(root.right, next.val);
                }
            }
            return root;
        }
        private TreeNode findNext(TreeNode root){
            while(root.left != null){
                root = root.left;
            }
            return root;
        }
    }
}