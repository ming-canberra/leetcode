package easy;

public class SameTree100 {
    public static void main(String[] args) {
        SameTree100 thisClass = new SameTree100();
        System.out.println(thisClass.isSameTree(null, null));
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