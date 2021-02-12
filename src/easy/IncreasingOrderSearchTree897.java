package easy;

import java.util.ArrayList;
import java.util.Stack;

public class IncreasingOrderSearchTree897 {
    public static void main(String[] args) {
        IncreasingOrderSearchTree897 thisClass = new IncreasingOrderSearchTree897();
        TreeNode a = thisClass.increasingBST(null);
            System.out.println(a);
    }
    public TreeNode increasingBST(TreeNode root) {
        ArrayList <Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack  = new Stack<TreeNode>();

        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode current = stack.pop();

            if (current.left == current.right && current.right == null){
                list.add(current.val);
            }
            else {
                if(current.right != null){
                    stack.push(current.right);
                }
                stack.push(current);
                TreeNode left = current.left;
                current.left = null;
                current.right = null;

                if(left != null){
                    stack.push(left);
                }
            }
        }
        TreeNode ans = new TreeNode(list.get(0));

        TreeNode tmp = ans;

        for (int i = 1; i < list.size(); i++){
            tmp.right = new TreeNode(list.get(i));
            tmp = tmp.right;
        }

        return ans;
    }
}