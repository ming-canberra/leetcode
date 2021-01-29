package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        BinaryTreePreorderTraversal thisClass = new BinaryTreePreorderTraversal();
        thisClass.preorderTraversal(null);
        StringBuilder sb = new StringBuilder();
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if (root == null){
            return ans;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode n = stack.pop();
            ans.add(n.val);

            if (n.right != null){
                stack.push(n.right);
            }

            if (n.left != null){
                stack.push(n.left);
            }
        }

        return ans;
    }
}