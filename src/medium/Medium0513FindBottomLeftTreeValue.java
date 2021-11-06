package medium;

import java.util.*;

public class Medium0513FindBottomLeftTreeValue {
    class Solution {
        public int findBottomLeftValue(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()){
                int result = 0;
                int oriSize = queue.size();
                for (int size = oriSize; size > 0; size--){
                    TreeNode top = queue.poll();
                    if (size == oriSize){
                        result = top.val;
                    }
                    if (top.left != null){
                        queue.add(top.left);
                    }
                    if (top.right != null){
                        queue.add(top.right);
                    }
                }
                if (queue.isEmpty()){
                    return result;
                }
            }
            return 0;
        }
    }
}