package medium;

import java.util.*;

public class Medium95UniqueBinarySearchTreesII {
    class Solution {
        public List<TreeNode> generateTrees(int n){
            return dfs(1, n);
        }
        private List<TreeNode> dfs(int start, int end){
            List<TreeNode> result = new ArrayList<>();
            if (start > end){
                result.add(null);
                return result;
            }
            for (int i = start; i <= end; i++){
                List<TreeNode> leftList = dfs(start, i - 1);
                List<TreeNode> rightList = dfs(i + 1, end);
                for (TreeNode left : leftList){
                    for (TreeNode right : rightList){
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        result.add(root);
                    }
                }
            }
            return result;
        }
    }
}