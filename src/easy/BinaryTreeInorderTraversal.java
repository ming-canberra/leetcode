package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        BinaryTreeInorderTraversal thisClass = new BinaryTreeInorderTraversal();
        thisClass.preorderTraversal(null);
        StringBuilder sb = new StringBuilder();
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        return null;
    }


    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();

        helper(root, ans);
        return ans;
    }
    private void helper(TreeNode root, List<Integer> ans){
        if (root != null) {
            if (root.left != null) {
                helper(root.left, ans);
            }
                ans.add(root.val);
                if (root.right != null) {
                    helper(root.right, ans);
                } else {
                    return;
                }

        }
    }

}