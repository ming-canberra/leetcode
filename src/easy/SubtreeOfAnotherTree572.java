package easy;

public class SubtreeOfAnotherTree572 {
    public boolean isSubtree(TreeNode bigTree, TreeNode smallTree) {

        if (bigTree == null){
            return false;
        }
        boolean compareResult = isSameTree(bigTree, smallTree);

        if (compareResult){
            return true;
        }
        else{
            return isSubtree(bigTree.left, smallTree) || isSubtree(bigTree.right, smallTree);
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q != null ){
            return false;
        }
        else if (p != null && q == null ){
            return false;
        }
        else if (p == null && q == null ){
            return true;
        }
        else if (p.val != q.val){
            return false;
        }
        else{
            return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
        }
    }

    class Solution {
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {

            if (equal(root, subRoot)){
                return true;
            }

            if (root != null){
                if (isSubtree(root.left, subRoot)){
                    return true;
                }
                if (isSubtree(root.right, subRoot)){
                    return true;
                }
            }

            return false;
        }

        private boolean equal(TreeNode a, TreeNode b){
            if (a == null && b == null){
                return true;
            }
            else if (a == null && b != null){
                return false;
            }
            else if (a != null && b == null){
                return false;
            }
            else{
                return a.val == b.val && equal(a.left, b.left) && equal(a.right, b.right);
            }
        }

    }
}