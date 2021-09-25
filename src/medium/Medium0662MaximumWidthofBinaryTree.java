package medium;

import java.util.*;

public class Medium0662MaximumWidthofBinaryTree {
    class Solution {
        public int widthOfBinaryTree(TreeNode root) {
            int result = 1;
            Map<TreeNode, Integer> map = new HashMap<>();
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            map.put(root, 1);
            while(!q.isEmpty()){
                Integer start = null;
                Integer end = null;
                for (int i = q.size(); i > 0; i--){
                    TreeNode top = q.poll();
                    if (top.left != null){
                        q.add(top.left);
                        int index = map.get(top) * 2;
                        map.put(top.left, index);
                        if (start == null){
                            start = index;
                        }
                        end = index;
                    }
                    if (top.right != null){
                        q.add(top.right);
                        int index = map.get(top) * 2 + 1;
                        map.put(top.right, index);
                        if (start == null){
                            start = index;
                        }
                        end = index;
                    }
                }
                if (start != null){
                    result = Math.max(result, end - start + 1);
                }
            }
            return result;
        }
    }
}