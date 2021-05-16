package medium;

import java.util.*;

public class FindLargestValueInEachTreeRow515 {
    public static void main(String[] args) {
        FindLargestValueInEachTreeRow515 thisClass = new FindLargestValueInEachTreeRow515();
    }
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        result.add(root.val);
        while(!q.isEmpty()){
            int curSize = q.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i< curSize; i++){
                TreeNode cur = q.poll();
                if (cur.left != null){
                    q.add(cur.left);
                    max = Math.max(max, cur.left.val);
                }
                if (cur.right != null){
                    q.add(cur.right);
                    max = Math.max(max, cur.right.val);
                }
            }
            if (!q.isEmpty()){
                result.add(max);
            }
        }
        return result;
    }
}