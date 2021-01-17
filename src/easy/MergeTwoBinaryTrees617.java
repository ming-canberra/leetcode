package easy;

public class MergeTwoBinaryTrees617 {
    public static void main(String[] args) {
        MergeTwoBinaryTrees617 thisClass = new MergeTwoBinaryTrees617();
        System.out.println(thisClass.mergeTrees(null, null));
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null){
            return null;
        }

        TreeNode toReturn = new TreeNode();

        if (t1 == null && t2 != null){
            toReturn.val = t2.val;
            toReturn.left = mergeTrees(null, t2.left);
            toReturn.right = mergeTrees(null, t2.right);
        }
        else if (t1 != null && t2 == null){
            toReturn.val = t1.val;
            toReturn.left = mergeTrees(t1.left, null);
            toReturn.right = mergeTrees(t1.right, null);
        }
        else {
            toReturn.val = t1.val + t2.val;
            toReturn.left = mergeTrees(t1.left, t2.left);
            toReturn.right = mergeTrees(t1.right, t2.right);
        }

        return toReturn;
    }

}