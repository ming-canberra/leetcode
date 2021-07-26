package medium;

import java.util.HashSet;

public class LowestCommonAncestorOfABinaryTree236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeInfo result = generateTreeInfo(root, p, q);
        return result.lca;
    }
    private TreeInfo generateTreeInfo(TreeNode root, TreeNode p, TreeNode q){
        if (root != null){
            TreeInfo leftTreeInfo = generateTreeInfo(root.left, p, q);
            TreeInfo rightTreeInfo = generateTreeInfo(root.right, p, q);
            if (leftTreeInfo.lca != null){
                return leftTreeInfo;
            }
            if (rightTreeInfo.lca != null){
                return rightTreeInfo;
            }
            if (root.val == p.val || root.val == q.val){
                TreeInfo newOne = new TreeInfo();
                if ( leftTreeInfo.numNodesFound == 1 || rightTreeInfo.numNodesFound == 1){
                    newOne.lca = root;
                }
                else{
                    newOne.numNodesFound = 1;
                }
                return newOne;
            }
            else{
                if (leftTreeInfo.numNodesFound == 1 && rightTreeInfo.numNodesFound == 1){
                    TreeInfo newOne = new TreeInfo();
                    newOne.lca = root;
                    return newOne;
                }
                else if (leftTreeInfo.numNodesFound == 1){
                    return leftTreeInfo;
                }
                else if (rightTreeInfo.numNodesFound == 1){
                    return rightTreeInfo;
                }
            }
        }
        return new TreeInfo();
    }
    class TreeInfo{
        TreeNode lca = null;
        int numNodesFound = 0;
    }

    class Solution {
        private TreeNode result = null;
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            numGivenNodesFound(root, p, q);
            return result;
        }
        private int numGivenNodesFound(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null){
                return -1;
            }
            int numResult = -1;
            if (result == null){
                if (root == p || root == q){
                    numResult = 1;
                }
                int numL = numGivenNodesFound(root.left, p, q);
                if (numL > 0 && numResult == 1){
                    result = root;
                    return -1;
                }

                int numR = numGivenNodesFound(root.right, p, q);
                if (numR > 0 && numResult == 1){
                    result = root;
                    return -1;
                }

                if (numL + numR == 2){
                    result = root;
                    return -1;
                }
                numResult = Math.max(numResult, Math.max(numL, numR));
            }
            return numResult;
        }
    }
}