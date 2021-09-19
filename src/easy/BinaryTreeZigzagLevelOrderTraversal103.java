package easy;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal103 {
    public static void main(String[] args) {
        BinaryTreeZigzagLevelOrderTraversal103 thisClass = new BinaryTreeZigzagLevelOrderTraversal103();
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null)
        {
            return result;
        }

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        Queue<TreeNode> qHelper;

        q1.add(root);
        qHelper = q1;
        boolean leftToRight = true;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (!qHelper.isEmpty())
        {
            Queue emptyQ = q1.isEmpty()? q1 : q2;
            Queue nonEmptyQ = q1 == emptyQ ? q2 : q1;

            List<Integer> curList = new ArrayList<Integer>();

            if (!leftToRight)
            {
                while (!stack.isEmpty())
                {
                    curList.add(stack.pop().val);
                }
            }


            while (!qHelper.isEmpty())
            {
                TreeNode node = qHelper.poll();

                if (leftToRight){
                    curList.add(node.val);
                }

                if (node.left != null){

                    if (leftToRight){
                        stack.push(node.left);
                    }
                    emptyQ.add(node.left);
                }

                if (node.right != null){

                    if (leftToRight){
                        stack.push(node.right);
                    }
                    emptyQ.add(node.right);
                }
            }

            result.add(curList);

            qHelper = emptyQ;
            leftToRight = !leftToRight;
        }

        if (!stack.isEmpty())
        {
            List<Integer> curList = new ArrayList<Integer>();

            while (!stack.isEmpty())
            {
                curList.add(stack.pop().val);
            }

            result.add(curList);
        }

        return result;
    }

    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null){
                return result;
            }
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            boolean reverseList = false;
            while(!q.isEmpty()){
                List<Integer> curList = new ArrayList<>();
                for (int i = q.size(); i > 0; i--){
                    TreeNode top = q.poll();
                    curList.add(top.val);
                    if (top.left != null){
                        q.add(top.left);
                    }
                    if (top.right != null){
                        q.add(top.right);
                    }
                }
                if (reverseList){
                    Collections.reverse(curList);
                }
                result.add(curList);
                reverseList = !reverseList;
            }
            return result;
        }
    }
}