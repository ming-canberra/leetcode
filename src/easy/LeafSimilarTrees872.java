package easy;

import java.util.ArrayList;

public class LeafSimilarTrees872 {
    public static void main(String[] args) {
        LeafSimilarTrees872 thisClass = new LeafSimilarTrees872();
        boolean a = thisClass.leafSimilar(null,null);
            System.out.println(a);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> intArray1 = new ArrayList<Integer>();
        ArrayList<Integer> intArray2 = new ArrayList<Integer>();
        fun(root1, intArray1);
        fun(root2, intArray2);

        return intArray1.equals(intArray2);
    }

    private void fun(TreeNode root, ArrayList<Integer> intArray){
        if (root == null){
            return;
        }
        fun(root.left, intArray);
        if (root.left == null && root.right == null){
            intArray.add(root.val);
        }
        fun(root.right, intArray);
    }
}