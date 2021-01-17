package easy;

public class SubtreeOfAnotherTree572 {
    public static void main(String[] args) {
        SubtreeOfAnotherTree572 thisClass = new SubtreeOfAnotherTree572();
        System.out.println(thisClass.isSubtree(null, null));
    }
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
}