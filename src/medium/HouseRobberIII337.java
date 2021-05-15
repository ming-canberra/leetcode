package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HouseRobberIII337 {
    public static void main(String[] args) {
        HouseRobberIII337 thisClass = new HouseRobberIII337();
    }

    HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();

    public int rob(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (map.containsKey(root)){
            return map.get(root);
        }
        int lTree = rob(root.left);
        int rTree = rob(root.right);
        int lGrandChildrenTree = 0;
        if (root.left != null){
            lGrandChildrenTree = rob(root.left.left) + rob(root.left.right);
        }
        int rGrandChildrenTree = 0;
        if (root.right != null){
            rGrandChildrenTree = rob(root.right.left) + rob(root.right.right);
        }
        int result = Math.max(lTree + rTree, lGrandChildrenTree + rGrandChildrenTree + root.val);
        map.put(root, result);
        return result;
    }
}