package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        BinaryTreeRightSideView thisClass = new BinaryTreeRightSideView();

        List<Integer> res = thisClass.rightSideView(null);
        System.out.println(res);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        Queue<TreeNode> qNextLevel = new LinkedList<TreeNode>();
        Queue<TreeNode> tempQueue = null;
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if (cur.left != null){
                qNextLevel.add(cur.left);
            }
            if (cur.right != null){
                qNextLevel.add(cur.right);
            }
            if(queue.isEmpty()){
                result.add(cur.val);
                //swap with next level queue
                tempQueue = qNextLevel;
                qNextLevel = queue;
                queue = tempQueue;
            }
        }
        return result;
    }
}