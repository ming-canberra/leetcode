package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal thisClass = new BinaryTreeLevelOrderTraversal();
        thisClass.levelOrder(null);
        StringBuilder sb = new StringBuilder();
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null){
            return ans;
        }
        q.add(root);
        fun(q, ans);
        return ans;
    }

    private void fun(Queue<TreeNode> q, List<List<Integer>> ans){
        List<Integer> l = new ArrayList<Integer>();
        Queue<TreeNode> newQ = new LinkedList<TreeNode>();
        while (!q.isEmpty()){
            TreeNode n = q.remove();
            l.add(n.val);
            if (n.left != null){
                newQ.add(n.left);
            }
            if (n.right != null){
                newQ.add(n.right);
            }
        }
        if (!l.isEmpty()){
            ans.add(l);
        }
        if (!newQ.isEmpty()){
            fun(newQ, ans);
        }
    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            Queue<TreeNode> q = new LinkedList<>();
            if (root == null){
                return result;
            }
            q.add(root);
            while(!q.isEmpty()){
                int size = q.size();
                List<Integer> curList = new ArrayList<>();
                for (int i = 0; i < size; i++){
                    TreeNode top = q.poll();
                    curList.add(top.val);
                    if (top.left != null){
                        q.add(top.left);
                    }
                    if (top.right != null){
                        q.add(top.right);
                    }
                }
                result.add(curList);
            }
            return result;
        }
    }
}