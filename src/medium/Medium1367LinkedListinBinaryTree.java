package medium;

public class Medium1367LinkedListinBinaryTree {
    class Solution {
        public boolean isSubPath(ListNode head, TreeNode root) {
            if (matchNodePath(head, root)){
                return true;
            }
            if (root != null){
                if (isSubPath(head, root.left)){
                    return true;
                }
                if (isSubPath(head, root.right)){
                    return true;
                }
            }
            return false;
        }
        private boolean matchNodePath(ListNode head, TreeNode root){
            if(head == null){
                return true;
            }
            if (root == null){
                return false;
            }
            if (head.val == root.val){
                if (matchNodePath(head.next, root.left)){
                    return true;
                }
                if (matchNodePath(head.next, root.right)){
                    return true;
                }
            }
            return false;
        }
    }
}