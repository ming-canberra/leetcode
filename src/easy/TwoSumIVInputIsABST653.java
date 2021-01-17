package easy;

import java.util.HashSet;

public class TwoSumIVInputIsABST653 {
    public static void main(String[] args) {
        TwoSumIVInputIsABST653 thisClass = new TwoSumIVInputIsABST653();
        System.out.println(thisClass.findTarget(null, 1));
    }

    HashSet<Integer> _traversedNodes = new HashSet<Integer>();

    public boolean findTarget(TreeNode root, int k) {

        if (root == null){
            return false;
        }

        if (_traversedNodes.contains(k - root.val)){
            return true;
        }
        else{
            _traversedNodes.add(root.val);
        }

        return findTarget(root.left, k) || findTarget(root.right, k);
    }

}