package easy;

import java.util.*;

public class BinaryTreeLevelOrderTraversalII107 {
    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversalII107 thisClass = new BinaryTreeLevelOrderTraversalII107();
        thisClass.levelOrderBottom(null);
        StringBuilder sb = new StringBuilder();
    }

    Stack<List<TreeNode>> _stack = new Stack<List<TreeNode>>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null){
            return ans;
        }
        else{
            List<TreeNode> listOfNodes = new ArrayList<TreeNode>();
            listOfNodes.add(root);
            _stack.add(listOfNodes);
            fun(listOfNodes);
            while (!_stack.isEmpty()){
                List<TreeNode> list = _stack.pop();
                List<Integer> listOfInt = new ArrayList<Integer>();
                for (TreeNode t : list){
                    listOfInt.add(t.val);
                }
                ans.add(listOfInt);
            }
            return ans;
        }
    }

    private void fun(List<TreeNode> q){
        List<TreeNode> newList = new ArrayList<TreeNode>();
        for (TreeNode n : q)
        {
            if (n.left !=null){
                newList.add(n.left);
            }
            if (n.right != null){
                newList.add(n.right);
            }
        }
        if (!newList.isEmpty()){
            _stack.add(newList);
            fun(newList);
        }
        return;
    }
}