package medium;

import java.util.ArrayList;
import java.util.List;

public class BalanceABinarySearchTree {
    public static void main(String[] args) {
        BalanceABinarySearchTree thisClass = new BalanceABinarySearchTree();
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> intList = new ArrayList<>();
        inorder(root, intList);
        return buildBst(intList, 0, intList.size());
    }
    private TreeNode buildBst(List<Integer> list, int start, int finish){
        if (finish > start){
            int midIndex = start + (finish - start)/2;
            TreeNode result = new TreeNode(list.get(midIndex));
            result.left = buildBst(list, start, midIndex);;
            result.right = buildBst(list, midIndex + 1, finish);;
            return result;
        }
        return null;
    }
    private void inorder(TreeNode root, List<Integer> intList){
        if (root != null){
            inorder(root.left, intList);
            intList.add(root.val);
            inorder(root.right, intList);
        }
    }
}